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
fun PokemonCardItem(pokemon: Pokemon, size: Double, onClick: () -> Unit, ) {
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center) {
        Card(modifier = Modifier.size(size.dp)
            .clickable(true, null, null, onClick)) {

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround) {
                AsyncImage(model = pokemon.image, contentDescription = pokemon.name,
                    modifier = Modifier.size((size*0.85).dp))
                Text(pokemon.name, fontSize = 25.sp)
            }
        }
    }
}