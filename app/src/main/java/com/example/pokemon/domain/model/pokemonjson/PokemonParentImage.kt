package com.example.pokemon.domain.model.pokemonjson

import com.google.gson.annotations.SerializedName

data class PokemonParentImage(
    @SerializedName("home") var image: PokemonImage = PokemonImage()
)
