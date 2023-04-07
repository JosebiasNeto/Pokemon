package com.example.pokemon.domain.repository

import com.example.pokemon.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun getPokemons() : Flow<List<Pokemon>>
    var pokemons: List<Pokemon>
}