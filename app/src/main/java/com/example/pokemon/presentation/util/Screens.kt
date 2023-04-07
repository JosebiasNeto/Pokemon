package com.example.pokemon.presentation.util

sealed class Screens (val route: String) {
    object HomeScreen: Screens("home_screen/")
    object DetailsScreen: Screens("details_screen/")
}