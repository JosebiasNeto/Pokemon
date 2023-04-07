package com.example.pokemon.presentation.home

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
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

    Column {
        val pagerState = rememberPagerState()
        if(orientation == ORIENTATION_PORTRAIT) VerticalPager(
            pageCount = pokemons.size,
            state = pagerState,
            pageSpacing = -(screenWidth*0.60).dp
        ) {
            PokemonCardItem(pokemons[it], true) {
                navController.navigate(Screens.DetailsScreen.route + pokemons[it].id)
            }
        } else HorizontalPager(
            pageCount = pokemons.size,
            state = pagerState,
            pageSpacing = -(screenHeight*0.80).dp
        ) {
            PokemonCardItem(pokemons[it], false) {
                    navController.navigate(Screens.DetailsScreen.route + pokemons[it].id)
                }
        }
    }
}