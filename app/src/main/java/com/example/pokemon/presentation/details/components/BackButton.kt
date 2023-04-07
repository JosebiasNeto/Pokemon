package com.example.pokemon.presentation.details.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pokemon.R

@Composable
fun BackButton(onClick: () -> Unit) {
    IconButton(onClick = onClick, modifier = Modifier.padding(10.dp)) {
        Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_24),
        contentDescription = stringResource(id = R.string.back))
    }
}