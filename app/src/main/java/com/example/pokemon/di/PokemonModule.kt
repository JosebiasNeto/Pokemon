package com.example.pokemon.di

import com.example.pokemon.data.remote.FavoriteAPI
import com.example.pokemon.data.remote.PokemonAPI
import com.example.pokemon.data.remote.RetrofitBuilder
import com.example.pokemon.domain.repository.PokemonRepository
import com.example.pokemon.domain.repository.PokemonRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokemonModule {

    @Provides
    @Singleton
    fun providePokemonAPI() : PokemonAPI {
        return RetrofitBuilder.pokemonAPI
    }

    @Provides
    @Singleton
    fun providePokemonRepository(
        api: PokemonAPI,
        favoriteAPI: FavoriteAPI
    ) : PokemonRepository {
        return PokemonRepositoryImpl(api, favoriteAPI)
    }

    @Provides
    @Singleton
    fun provideFavoriteAPI() : FavoriteAPI {
        return RetrofitBuilder.favoriteAPI
    }
}