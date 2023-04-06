package com.example.pokemon.domain.model.pokemonjson

import com.google.gson.annotations.SerializedName

data class PokemonAPIResponse(
    @SerializedName("next") var nextRequest: String = "",
    @SerializedName("results") var pokemonBaseList: List<PokemonBase> = listOf()
)
