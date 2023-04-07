package com.example.pokemon.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokemon.presentation.details.DetailsScreen
import com.example.pokemon.presentation.home.HomeScreen
import com.example.pokemon.presentation.util.Screens
import com.example.pokemon.presentation.util.theme.PokemonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                    startDestination = Screens.HomeScreen.route) {
                        composable(route = Screens.HomeScreen.route) {
                            HomeScreen(navController = navController)
                        }
                        composable(route = Screens.DetailsScreen.route + "{pokemonId}",
                        arguments = listOf(navArgument("pokemonId") { type = NavType.IntType })) {
                            DetailsScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}