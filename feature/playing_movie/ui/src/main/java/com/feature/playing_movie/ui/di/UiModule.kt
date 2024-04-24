package com.feature.playing_movie.ui.di

import com.feature.playing_movie.ui.NowMoviePlayingApi
import com.feature.playing_movie.ui.NowMoviePlayingApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {
    @Provides
    fun provideNowPlayingMovieApi(): NowMoviePlayingApi {
        return NowMoviePlayingApiImpl()
    }
}