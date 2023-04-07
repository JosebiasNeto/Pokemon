package com.example.pokemon.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.example.pokemon.domain.model.Pokemon

@Composable
fun PokemonCardItem(pokemon: Pokemon, modifier: Modifier) {
    Card(modifier = modifier) {
        Column {
            AsyncImage(model = pokemon.image, contentDescription = pokemon.name)
            Text(pokemon.name)
        }
    }
}