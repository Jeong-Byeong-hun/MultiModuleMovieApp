package com.feature.playing_movie.domain.di

import com.feature.playing_movie.domain.repo.NowPlayingMovieRepository
import com.feature.playing_movie.domain.use_cases.GetNowPlayingMovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun provideGetPlayingMovieUseCase(playingMovieRepo: NowPlayingMovieRepository): GetNowPlayingMovieUseCase {
        return GetNowPlayingMovieUseCase(playingMovieRepo)
    }
}