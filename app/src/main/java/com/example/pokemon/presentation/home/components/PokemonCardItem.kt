package com.example.pokemon.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokemon.domain.model.Pokemon

@Composable
fun PokemonCardItem(pokemon: Pokemon, isVertical: Boolean, onClick: () -> Unit, ) {
    val modifier: Modifier = if(isVertical) {
        Modifier
            .fillMaxWidth()
            .clickable(true, null, null, onClick)
            .padding(30.dp)
    } else {
        Modifier
            .fillMaxHeight()
            .clickable(true, null, null, onClick)
            .padding(10.dp)
    }
    Card(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(model = pokemon.image, contentDescription = pokemon.name)
            Spacer(modifier = Modifier.size(10.dp))
            Text(pokemon.name, fontSize = 30.sp)
            Spacer(modifier = Modifier.size(10.dp))
        }
    }
}