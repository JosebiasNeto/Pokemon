package com.example.pokemon.domain.model.pokemonjson

import com.google.gson.annotations.SerializedName

data class PokemonImage(
    @SerializedName("front_default") var image: String = ""
)