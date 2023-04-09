package com.example.pokemon.presentation.details.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemon.R
import com.example.pokemon.domain.model.Pokemon

@Composable
fun DetailsScreenDescription(size: Double, pokemon: Pokemon, favoriteClick: () -> Unit) {
    Column(modifier = Modifier.size(size.dp), horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceBetween) {
        Row { 
            Text(text = stringResource(id = R.string.experience))
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = pokemon.experience.toString())
        }
        Row {
            Text(text = stringResource(id = R.string.weight),
            fontSize = 20.sp)
            Text(text = pokemon.weight.toString(),
                fontSize = 20.sp)
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = stringResource(id = R.string.height),
                fontSize = 20.sp)
            Text(text = pokemon.height.toString(),
                fontSize = 20.sp)
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(id = R.string.hp))
                Text(text = pokemon.hpStat.toString())
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(id = R.string.attack))
                Text(text = pokemon.attackStat.toString())
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(id = R.string.defense))
                Text(text = pokemon.defenseStat.toString())
            }
        }
        Card( Modifier.clickable(true, null, null, favoriteClick) ) {
            Text(text = stringResource(id = R.string.favorite),
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 7.dp), fontSize = 25.sp)
        }
        Spacer(modifier = Modifier.size(10.dp))
    }
}