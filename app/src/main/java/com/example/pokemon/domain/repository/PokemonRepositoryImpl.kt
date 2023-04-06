package com.example.pokemon.domain.repository

import com.example.pokemon.data.remote.PokemonAPI
import com.example.pokemon.domain.model.Pokemon
import com.example.pokemon.domain.model.pokemonjson.PokemonBase
import com.example.pokemon.domain.model.pokemonjson.PokemonConverter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepositoryImpl(private val pokemonAPI: PokemonAPI) : PokemonRepository {

    private var nextURL = ""

    override suspend fun getPokemons(): List<Pokemon> {
        val pokemonsBase = arrayListOf<PokemonBase>()
        val pokemons = arrayListOf<Pokemon>()
        withContext(Dispatchers.IO){
            pokemonsBase.addAll(getPokemonsBase())
        }
        withContext(Dispatchers.IO){
            pokemonsBase.forEach { pokemons.add(getPokemonResult(it)) }
        }
        return pokemons
    }

    private suspend fun getPokemonsBase() : List<PokemonBase> {
        return if(nextURL.isNotEmpty()){
            pokemonAPI.getPokemonBaseList().pokemonBaseList
        } else pokemonAPI.getPokemonBaseList().pokemonBaseList
    }

    private suspend fun getPokemonResult(pokemonBase: PokemonBase) : Pokemon {
        return PokemonConverter.fromJson(pokemonAPI.getPokemon(pokemonBase.url))
    }
}