package com.example.pokemon.presentation.home

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.CircularProgressIndicator
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

    val pagerState = rememberPagerState()
    if(orientation == ORIENTATION_PORTRAIT) {
        Box(Modifier.background(MaterialTheme.colors.primary)) {
            VerticalPager(
                pageCount = pokemons.size,
                state = pagerState,
                horizontalAlignment = Alignment.CenterHorizontally,
                pageSpacing = -(screenHeight * 0.40).dp
            ) {
                PokemonCardItem(pokemons[it], minScreenSize) {
                    navController.navigate(Screens.DetailsScreen.route + pokemons[it].id)
                }
                if(it == pokemons.size -1 && !viewModel.isLoading.value) viewModel.getPokemons()
            }
            if(viewModel.isLoading.value){
                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = if(pokemons.isEmpty()) Alignment.Center else Alignment.BottomCenter) {
                    CircularProgressIndicator(strokeWidth = 5.dp, color = androidx.compose.ui.graphics.Color.Green,
                        modifier = Modifier.padding(bottom = 20.dp))
                }
            }
        }
    } else {
        Box(Modifier.background(MaterialTheme.colors.primary)) {
            if(pokemons.isNotEmpty()) HorizontalPager(
                pageCount = pokemons.size,
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                pageSpacing = -(screenWidth * 0.45).dp
            ) {
                PokemonCardItem(pokemons[it], minScreenSize) {
                    navController.navigate(Screens.DetailsScreen.route + pokemons[it].id)
                }
                if(it == pokemons.size -1 && !viewModel.isLoading.value) viewModel.getPokemons()
            }
            if(viewModel.isLoading.value){
                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = if(pokemons.isEmpty()) Alignment.Center else Alignment.CenterEnd) {
                    CircularProgressIndicator(strokeWidth = 5.dp, color = androidx.compose.ui.graphics.Color.Green,
                        modifier = Modifier.padding(bottom = 20.dp))
                }
            }
        }
    }
}