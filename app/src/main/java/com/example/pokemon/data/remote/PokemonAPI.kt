package com.example.pokemon.data.remote

import com.example.pokemon.domain.model.pokemonjson.PokemonAPIResponse
import com.example.pokemon.domain.model.pokemonjson.PokemonFromJson
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAPI {

    @GET("pokemon")
    suspend fun getPokemonBaseList(@Query("offset") finalIndex: Int) : PokemonAPIResponse

    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: String) : PokemonFromJson
}