package com.example.pokemon.domain.model.pokemonjson

import com.example.pokemon.domain.model.Pokemon

object PokemonConverter {
    fun toJson(pokemon: Pokemon) : PokemonFromJson {
        return PokemonFromJson()
    }

    fun fromJson(pokemonFromJson: PokemonFromJson) : Pokemon {
        return Pokemon(
            id = pokemonFromJson.id,
            name = pokemonFromJson.name,
            experience = pokemonFromJson.experience,
            height = pokemonFromJson.height,
            weight = pokemonFromJson.weight,
            type = pokemonFromJson.types[0].type.name,
            hpStat = getHpStatValue(pokemonFromJson.stats),
            attackStat = getAttackStatValue(pokemonFromJson.stats),
            defenseStat = getDefenseStatValue(pokemonFromJson.stats),
            image = pokemonFromJson.image.image
        )
    }

    private fun getHpStatValue(stats: List<PokemonBaseStat>
    ) : Int = getStatValue(stats, "hp")
    private fun getAttackStatValue(stats: List<PokemonBaseStat>
    ) : Int = getStatValue(stats, "attack")
    private fun getDefenseStatValue(stats: List<PokemonBaseStat>
    ) : Int = getStatValue(stats, "defense")
    private fun getStatValue(stats: List<PokemonBaseStat>, name: String) : Int {
        stats.forEach {
            if(it.stat.name == name) return it.value
        }
        return -1
    }
}