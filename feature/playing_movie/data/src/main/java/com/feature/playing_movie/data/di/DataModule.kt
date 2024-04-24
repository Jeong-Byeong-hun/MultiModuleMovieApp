package com.feature.playing_movie.data.di

import com.core.network.dataproviders.MovieDataProviders
import com.feature.playing_movie.data.repo.NowPlayingRepoImpl
import com.feature.playing_movie.domain.repo.NowPlayingMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun getProvidePlayingMovieRepo(movieDataProviders: MovieDataProviders) : NowPlayingMovieRepository{
        return NowPlayingRepoImpl(movieDataProviders)
    }
}