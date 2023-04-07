package com.example.pokemon.domain.model.pokemonjson

import com.google.gson.annotations.SerializedName

data class PokemonBaseImage(
    @SerializedName("other") var image: PokemonParentImage = PokemonParentImage()
)