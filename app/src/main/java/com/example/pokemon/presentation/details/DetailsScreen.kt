package com.example.pokemon.presentation.details

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pokemon.domain.util.AppMath
import com.example.pokemon.presentation.details.components.BackButton
import com.example.pokemon.presentation.details.components.DetailsScreenDescription
import com.example.pokemon.presentation.details.components.DetailsScreenHeader

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
            DetailsScreenDescription(size = minScreenSize, pokemon)
        }
    } else {
        Row(Modifier.fillMaxSize()) {
            BackButton { navController.popBackStack() }
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                DetailsScreenHeader(pokemon = pokemon, minScreenSize)
            }
            DetailsScreenDescription(size = minScreenSize, pokemon)
        }
    }
}