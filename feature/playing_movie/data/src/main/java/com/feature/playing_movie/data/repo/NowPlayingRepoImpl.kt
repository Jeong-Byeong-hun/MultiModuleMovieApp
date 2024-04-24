package com.feature.playing_movie.data.repo

import com.core.network.dataproviders.MovieDataProviders
import com.feature.playing_movie.data.mapper.toDoMainPlayingMovieList
import com.feature.playing_movie.domain.model.NowPlayingMovie
import com.feature.playing_movie.domain.repo.NowPlayingMovieRepository
import javax.inject.Inject

class NowPlayingRepoImpl @Inject constructor(private val movieDataProviders: MovieDataProviders) :
    NowPlayingMovieRepository {
    override suspend fun getPlayingMovie(page: Int): List<NowPlayingMovie> {
        return movieDataProviders.getNowPlaying(page).toDoMainPlayingMovieList()
    }
}