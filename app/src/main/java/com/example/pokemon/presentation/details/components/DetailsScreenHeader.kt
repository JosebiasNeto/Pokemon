package com.example.pokemon.presentation.details.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokemon.domain.model.Pokemon

@Composable
fun DetailsScreenHeader(pokemon: Pokemon, size: Double) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.size((size*0.8).dp)) {
        AsyncImage(model = pokemon.image, contentDescription = pokemon.name,
        modifier = Modifier.size((size*0.6).dp))
        Spacer(modifier = Modifier.size(5.dp))
        Text(pokemon.name)
        Text(pokemon.type, fontSize = 20.sp)
    }
}