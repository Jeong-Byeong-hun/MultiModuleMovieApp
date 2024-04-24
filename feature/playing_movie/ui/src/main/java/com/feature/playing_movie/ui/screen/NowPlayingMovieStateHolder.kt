package com.feature.playing_movie.ui.screen

import com.feature.playing_movie.domain.model.NowPlayingMovie

data class NowPlayingMovieStateHolder(
    val isLoading: Boolean = false,
    val data: List<NowPlayingMovie>? = null,
    val error: String = ""
)