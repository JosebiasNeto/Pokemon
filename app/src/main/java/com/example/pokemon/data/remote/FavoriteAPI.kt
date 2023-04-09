package com.example.pokemon.data.remote

import com.example.pokemon.domain.model.pokemonjson.PokemonFromJson
import retrofit2.http.Body
import retrofit2.http.POST

interface FavoriteAPI {

    @POST("361949cb-84c0-4bc0-b35c-cf7c066dc6fb")
    suspend fun favoritePokemon(@Body pokemon: PokemonFromJson)

}