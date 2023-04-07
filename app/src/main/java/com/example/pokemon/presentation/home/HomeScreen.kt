package com.example.pokemon.presentation.home

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
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

    Surface() {
        if(orientation == ORIENTATION_PORTRAIT) LazyColumn {
            items(pokemons) {pokemon ->
                PokemonCardItem(pokemon,
                Modifier.clickable {
                    navController.navigate(Screens.DetailsScreen.route
                    + pokemon.id)
                })
            }
        } else LazyRow {
            items(pokemons) {pokemon ->
                PokemonCardItem(pokemon,
                    Modifier.clickable {
                        navController.navigate(Screens.DetailsScreen.route)
                    })
            }
        }
    }
}