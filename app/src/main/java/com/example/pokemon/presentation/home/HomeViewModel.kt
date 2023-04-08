package com.example.pokemon.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.domain.model.Pokemon
import com.example.pokemon.domain.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pokemonRepository : PokemonRepository
) : ViewModel() {

    private val _pokemons = mutableStateOf<List<Pokemon>>(emptyList())
    val pokemons: State<List<Pokemon>> = _pokemons

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    init {
        getPokemons()
    }

    fun getPokemons() {
        viewModelScope.launch {
            _isLoading.value = true
            pokemonRepository.getPokemons().collect {
                _pokemons.value = it
            }
            _isLoading.value = false
        }
    }
}