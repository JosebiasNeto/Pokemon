package com.example.pokemon.domain.model.pokemonjson

import com.google.gson.annotations.SerializedName

data class PokemonBaseStat(
    @SerializedName("base_stat") var value: Int = -1,
    var stat: PokemonStat = PokemonStat()
)
