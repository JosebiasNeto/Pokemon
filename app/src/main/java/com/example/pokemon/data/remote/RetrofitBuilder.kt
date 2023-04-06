package com.example.pokemon.data.remote


import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    fun getRetrofit(): Retrofit {
        val gson = GsonBuilder()
            .setLenient().create()
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://pokeapi.co/api/v2/pokemon/")
            .build()
    }

    val pokemonAPI: PokemonAPI = getRetrofit().create(PokemonAPI::class.java)
}