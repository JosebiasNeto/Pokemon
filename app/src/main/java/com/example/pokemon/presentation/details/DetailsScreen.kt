package com.example.pokemon.presentation.details

import android.content.Context
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pokemon.domain.util.AppMath
import com.example.pokemon.presentation.details.components.BackButton
import com.example.pokemon.presentation.details.components.DetailsScreenDescription
import com.example.pokemon.presentation.details.components.DetailsScreenHeader
import com.example.pokemon.presentation.util.FavoriteState

@Composable
fun DetailsScreen(
    navController: NavController,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val pokemon = viewModel.pokemon.value
    val orientation = LocalConfiguration.current.orientation
    val minScreenSize = AppMath.getMinValue(
        LocalConfiguration.current.screenHeightDp.toDouble(),
        LocalConfiguration.current.screenWidthDp.toDouble()
    )

    if(orientation == ORIENTATION_PORTRAIT) {
        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.secondary)) {
            BackButton { navController.popBackStack() }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                DetailsScreenHeader(pokemon = pokemon, minScreenSize)
            }
            DetailsScreenDescription(size = minScreenSize, pokemon){
                viewModel.favoritePokemon()
            }
        }
    } else {
        Row(Modifier.fillMaxSize()) {
            BackButton { navController.popBackStack() }
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                DetailsScreenHeader(pokemon = pokemon, minScreenSize)
            }
            DetailsScreenDescription(size = minScreenSize, pokemon){
                viewModel.favoritePokemon()
            }
        }
    }
    favoriteFeedback(viewModel.favoriteState.value, LocalContext.current)
    viewModel.showedToast()
}

private fun favoriteFeedback(favoriteState: FavoriteState, context: Context) {
    if(favoriteState == FavoriteState.success){
        Toast.makeText(context, "Favoritou", Toast.LENGTH_SHORT).show()
    } else if(favoriteState == FavoriteState.failure) {
        Toast.makeText(context, "Deu merda", Toast.LENGTH_SHORT).show()
    }
}