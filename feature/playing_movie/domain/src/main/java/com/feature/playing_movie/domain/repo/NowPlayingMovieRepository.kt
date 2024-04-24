package com.feature.playing_movie.domain.repo

import com.feature.playing_movie.domain.model.NowPlayingMovie

interface NowPlayingMovieRepository {
    suspend fun getPlayingMovie(page: Int): List<NowPlayingMovie>
}