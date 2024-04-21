package com.example.multimodulemovieapp.di

import com.example.multimodulemovieapp.navigation.NavigationProviders
import com.feature.movie.ui.navigation.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigationProvider(movieApi:MovieApi):NavigationProviders{
        return NavigationProviders(movieApi)
    }
}