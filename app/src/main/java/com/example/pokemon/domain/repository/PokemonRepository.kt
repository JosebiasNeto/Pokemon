package com.example.pokemon.domain.repository

import com.example.pokemon.domain.model.Pokemon

interface PokemonRepository {
    suspend fun getPokemons() : List<Pokemon>
}