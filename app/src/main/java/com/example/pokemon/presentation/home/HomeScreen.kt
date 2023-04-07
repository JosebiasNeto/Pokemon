package com.example.pokemon.presentation.home

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokemon.domain.util.AppMath
import com.example.pokemon.presentation.home.components.PokemonCardItem
import com.example.pokemon.presentation.util.Screens


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val pokemons = viewModel.pokemons.value
    val orientation = LocalConfiguration.current.orientation
    val screenHeight = LocalConfiguration.current.screenHeightDp
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val minScreenSize = AppMath.getMinValue(screenHeight*0.85, screenWidth*0.85)

    Column(Modifier.background(MaterialTheme.colors.primary)) {
        val pagerState = rememberPagerState()
        if(orientation == ORIENTATION_PORTRAIT) VerticalPager(
            pageCount = pokemons.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            pageSpacing = -(screenHeight*0.40).dp
        ) {
            PokemonCardItem(pokemons[it], minScreenSize) {
                navController.navigate(Screens.DetailsScreen.route + pokemons[it].id)
            }
        } else HorizontalPager(
            pageCount = pokemons.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            pageSpacing = -(screenWidth*0.45).dp
        ) {
            PokemonCardItem(pokemons[it], minScreenSize) {
                    navController.navigate(Screens.DetailsScreen.route + pokemons[it].id)
                }
        }
    }
}