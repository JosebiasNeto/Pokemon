package com.example.pokemon.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.domain.model.Pokemon
import com.example.pokemon.domain.repository.PokemonRepository
import com.example.pokemon.presentation.util.FavoriteState
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

    private val _favoriteState = mutableStateOf(FavoriteState.empty)
    val favoriteState: State<FavoriteState> = _favoriteState

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

    fun favoritePokemon() {
        viewModelScope.launch {
            val isSuccess = pokemonRepository.favoritePokemon(_pokemon.value)
            _favoriteState.value = if(isSuccess) FavoriteState.success
            else FavoriteState.failure
        }
    }

    fun showedToast() {
        _favoriteState.value = FavoriteState.empty
    }
}