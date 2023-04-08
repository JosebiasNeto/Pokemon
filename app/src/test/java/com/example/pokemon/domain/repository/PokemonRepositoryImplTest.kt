package com.example.pokemon.domain.repository

import com.example.pokemon.data.remote.RetrofitBuilder
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.runBlocking
import org.junit.Rule

import org.junit.Test


class PokemonRepositoryImplTest {

    @get:Rule
    val mockkRule = MockKRule(this)

    @Test
    fun getPokemons_success() = runBlocking {
        val repository = PokemonRepositoryImpl(RetrofitBuilder.pokemonAPI)

        repository.getPokemons().collect {
            assert(it[0].name == "Bulbasaur")
        }
    }
}