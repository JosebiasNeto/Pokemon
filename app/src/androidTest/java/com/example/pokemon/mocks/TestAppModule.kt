package com.example.pokemon.mocks

import androidx.lifecycle.SavedStateHandle
import com.example.pokemon.presentation.details.DetailsViewModel
import com.example.pokemon.presentation.home.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Named("test_home_screen")
    fun provideHomeScreenViewModel() : HomeViewModel {
        return HomeViewModel(PokemonRepositoryMock())
    }

    @Provides
    @Named("test_details_screen")
    fun provideDetailsScreenViewModel() : DetailsViewModel {
        return DetailsViewModel(
            SavedStateHandle(mapOf("pokemonId" to pokemonMock.id)),
            PokemonRepositoryMock())
    }

}