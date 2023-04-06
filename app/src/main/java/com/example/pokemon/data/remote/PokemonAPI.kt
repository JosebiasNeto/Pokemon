package com.example.pokemon.data.remote

import com.example.pokemon.domain.model.pokemonjson.PokemonAPIResponse
import com.example.pokemon.domain.model.pokemonjson.PokemonFromJson
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPI {

    @GET("/")
    suspend fun getPokemonBaseList() : PokemonAPIResponse

    @GET("{url}")
    suspend fun getPokemon(@Path("url") url: String) : PokemonFromJson
}