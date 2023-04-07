package com.example.pokemon.presentation.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
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
    modifier = Modifier.size(size.dp)) {
        AsyncImage(model = pokemon.image, contentDescription = pokemon.name)
        Spacer(modifier = Modifier.size(5.dp))
        Text(pokemon.name, fontSize = 17.sp)
        Spacer(modifier = Modifier.size(5.dp))
        Text(pokemon.type, fontSize = 10.sp)
    }
}