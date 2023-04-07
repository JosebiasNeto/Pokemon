package com.example.pokemon.domain.model.pokemonjson

import com.google.gson.annotations.SerializedName

data class PokemonFromJson(
    var id: Int = -1,
    var name: String = "",
    @SerializedName("base_experience") var experience: Int = -1,
    var height: Int = -1,
    var weight: Int = -1,
    var types: List<PokemonBaseType> = listOf(),
    var stats: List<PokemonBaseStat> = listOf(),
    @SerializedName("sprites") var image: PokemonBaseImage = PokemonBaseImage()
)
