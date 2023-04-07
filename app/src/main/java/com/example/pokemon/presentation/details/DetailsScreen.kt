package com.example.pokemon.presentation.details

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pokemon.domain.util.AppMath
import com.example.pokemon.presentation.details.components.BackButton
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
        Column(Modifier.fillMaxSize()) {
            BackButton { navController.popBackStack() }
            DetailsScreenHeader(pokemon = pokemon, minScreenSize)
        }
    } else {
        Row(Modifier.fillMaxSize()) {
            BackButton { navController.popBackStack() }
            DetailsScreenHeader(pokemon = pokemon, minScreenSize)
        }
    }
}