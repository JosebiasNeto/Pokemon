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
    fun getPokemons() = runBlocking {
        val repository = PokemonRepositoryImpl(RetrofitBuilder.pokemonAPI)

        assert(repository.getPokemons()[0].name == "bulbasaur")
    }
}