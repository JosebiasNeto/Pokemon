package com.example.pokemon.domain.model.pokemonjson

import com.example.pokemon.domain.model.Pokemon
import com.example.pokemon.domain.util.Constants.STAT_ATTACK
import com.example.pokemon.domain.util.Constants.STAT_DEFENSE
import com.example.pokemon.domain.util.Constants.STAT_HP
import com.example.pokemon.domain.util.capitalizeEveryFirstChar

object PokemonConverter {
    fun toJson(pokemon: Pokemon) : PokemonFromJson {
        return PokemonFromJson(
            id = pokemon.id,
            name = pokemon.name,
            experience = pokemon.experience,
            height = pokemon.height,
            weight = pokemon.weight,
            types = arrayListOf(PokemonBaseType(PokemonType(pokemon.type))),
            stats = getStatFromHpAttackDefense(pokemon.hpStat, pokemon.attackStat, pokemon.defenseStat)
        )
    }

    fun fromJson(pokemonFromJson: PokemonFromJson) : Pokemon {
        return Pokemon(
            id = pokemonFromJson.id,
            name = pokemonFromJson.name.capitalizeEveryFirstChar(),
            experience = pokemonFromJson.experience,
            height = pokemonFromJson.height,
            weight = pokemonFromJson.weight,
            type = pokemonFromJson.types[0].type.name,
            hpStat = getHpStatValue(pokemonFromJson.stats),
            attackStat = getAttackStatValue(pokemonFromJson.stats),
            defenseStat = getDefenseStatValue(pokemonFromJson.stats),
            image = pokemonFromJson.image.image.image.image
        )
    }

    private fun getHpStatValue(stats: List<PokemonBaseStat>
    ) : Int = getStatValue(stats, STAT_HP)
    private fun getAttackStatValue(stats: List<PokemonBaseStat>
    ) : Int = getStatValue(stats, STAT_ATTACK)
    private fun getDefenseStatValue(stats: List<PokemonBaseStat>
    ) : Int = getStatValue(stats, STAT_DEFENSE)
    private fun getStatValue(stats: List<PokemonBaseStat>, name: String) : Int {
        stats.forEach {
            if(it.stat.name == name) return it.value
        }
        return -1
    }

    private fun getStatFromHpAttackDefense(hp: Int, attack: Int, defense: Int): List<PokemonBaseStat> {
        return arrayListOf(
            PokemonBaseStat(
                value = hp,
                PokemonStat(STAT_HP)
            ),
            PokemonBaseStat(
                value = attack,
                PokemonStat(STAT_ATTACK)
            ),
            PokemonBaseStat(
                value = defense,
                PokemonStat(STAT_DEFENSE)
            )
        )
    }
}