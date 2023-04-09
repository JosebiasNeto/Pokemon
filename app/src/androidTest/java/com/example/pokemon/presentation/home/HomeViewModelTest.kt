package com.example.pokemon.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.pokemon.domain.repository.PokemonRepository
import com.example.pokemon.mocks.PokemonRepositoryMock
import com.example.pokemon.mocks.pokemonMock
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel
    private lateinit var pokemonRepository: PokemonRepository

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        pokemonRepository = PokemonRepositoryMock()
    }

    @Test
    fun getPokemons() = runBlocking {
        viewModel = HomeViewModel(pokemonRepository)
        delay(5000)
        Assert.assertEquals(pokemonMock.id, viewModel.pokemons.value[0].id)
        Assert.assertEquals(pokemonMock.name, viewModel.pokemons.value[0].name)
    }

    @Test
    fun isLoading() = runBlocking {
        viewModel = HomeViewModel(pokemonRepository)
        Assert.assertEquals(true, viewModel.isLoading.value)
        delay(5000)
        Assert.assertEquals(false, viewModel.isLoading.value)
    }
}