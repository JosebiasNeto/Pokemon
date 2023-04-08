package com.example.pokemon.mocks

import com.example.pokemon.domain.model.Pokemon
import com.example.pokemon.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonRepositoryMock() : PokemonRepository {

    override val pokemons: ArrayList<Pokemon> = arrayListOf(pokemonMock)

    override suspend fun getPokemons(): Flow<List<Pokemon>> = flow {
        emit(arrayListOf(pokemonMock))
    }
}