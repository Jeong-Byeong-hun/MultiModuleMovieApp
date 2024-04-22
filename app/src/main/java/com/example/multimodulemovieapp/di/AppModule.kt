package com.example.multimodulemovieapp.di

import com.example.multimodulemovieapp.navigation.NavigationProviders
import com.feature.movie.ui.navigation.MovieApi
import com.feature.movie_details.ui.navigation.MovieDetailsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigationProvider(
        movieApi: MovieApi,
        movieDetailsApi: MovieDetailsApi
    ): NavigationProviders {
        return NavigationProviders(movieApi, movieDetailsApi)
    }
}