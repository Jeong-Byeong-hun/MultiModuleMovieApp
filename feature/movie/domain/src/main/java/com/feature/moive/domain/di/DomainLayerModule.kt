package com.feature.moive.domain.di

import com.feature.moive.domain.repo.MovieRepository
import com.feature.moive.domain.use_cases.GetMovieListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun provideGetMovieListUseCase(movieRepository: MovieRepository):GetMovieListUseCase{
        return GetMovieListUseCase(movieRepository)
    }
}