package com.example.pokemon.presentation.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.example.pokemon.domain.repository.PokemonRepository
import com.example.pokemon.mocks.PokemonRepositoryMock
import com.example.pokemon.mocks.pokemonMock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DetailsViewModelTest {

    private lateinit var viewModel: DetailsViewModel
    private lateinit var pokemonRepository: PokemonRepository
    private lateinit var savedStateHandle: SavedStateHandle

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        pokemonRepository = PokemonRepositoryMock()
        savedStateHandle = SavedStateHandle(mapOf("pokemonId" to pokemonMock.id))
        viewModel = DetailsViewModel(savedStateHandle, pokemonRepository)
    }

    @Test
    fun getPokemon_success() = runBlocking {
        delay(5000)
        assertEquals(pokemonMock.id, viewModel.pokemon.value.id)
        assertEquals(pokemonMock.name, viewModel.pokemon.value.name)
    }
}