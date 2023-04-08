package com.example.pokemon.domain.repository

import com.example.pokemon.data.remote.PokemonAPI
import com.example.pokemon.domain.model.Pokemon
import com.example.pokemon.domain.model.pokemonjson.PokemonBase
import com.example.pokemon.domain.model.pokemonjson.PokemonConverter
import com.example.pokemon.domain.util.Constants.URL_USED
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class PokemonRepositoryImpl(private val pokemonAPI: PokemonAPI) : PokemonRepository {

    private var index = 0
    override val pokemons: ArrayList<Pokemon> = arrayListOf()

    override suspend fun getPokemons(): Flow<List<Pokemon>> = flow {
        val pokemonsBase = arrayListOf<PokemonBase>()
        val pokemonsFromAPI = arrayListOf<Pokemon>()
        withContext(Dispatchers.IO){
            pokemonsBase.addAll(getPokemonsBase())
        }
        withContext(Dispatchers.IO){
            pokemonsBase.forEach { pokemonsFromAPI.add(getPokemonResult(it)) }
        }
        pokemons.addAll(pokemonsFromAPI)
        emit(pokemons)
    }

    private suspend fun getPokemonsBase() : List<PokemonBase> {
        val pokemonBase = pokemonAPI.getPokemonBaseList(index)
        index += 20
        return pokemonBase.pokemonBaseList
    }

    private suspend fun getPokemonResult(pokemonBase: PokemonBase) : Pokemon {
        return PokemonConverter.fromJson(pokemonAPI.getPokemon(pokemonBase.url
            .replace(URL_USED, "")))
    }
}