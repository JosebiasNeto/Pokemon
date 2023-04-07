package com.example.pokemon.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.domain.model.Pokemon
import com.example.pokemon.domain.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val pokemonRepository : PokemonRepository
) : ViewModel() {

    private val _pokemon = mutableStateOf(Pokemon())
    val pokemon: State<Pokemon> = _pokemon

    init {
        savedStateHandle.get<Int>("pokemonId")?.let {
            getPokemon(it)
        }
    }

    private fun getPokemon(id: Int) {
        viewModelScope.launch {
            pokemonRepository.pokemons.forEach {
                if(it.id == id) _pokemon.value = it
            }
        }
    }
}