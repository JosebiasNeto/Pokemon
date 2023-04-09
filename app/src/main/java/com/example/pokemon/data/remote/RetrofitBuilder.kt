package com.example.pokemon.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://pokeapi.co/api/v2/")
            .build()
    }

    fun getFavoriteRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://webhook.site/")
            .build()
    }

    val pokemonAPI: PokemonAPI = getRetrofit().create(PokemonAPI::class.java)
    val favoriteAPI: FavoriteAPI = getFavoriteRetrofit().create(FavoriteAPI::class.java)
}