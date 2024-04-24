package com.feature.playing_movie.data.mapper

import com.core.network.model.NowPlayingResponse
import com.feature.playing_movie.domain.model.NowPlayingMovie


fun NowPlayingResponse.toDoMainPlayingMovieList(): List<NowPlayingMovie> {
    return this.results.map {
        NowPlayingMovie(
            imageUrl = makeFullUrl(it.poster_path),
            id = it.id.toString(),
            title = it.title
        )
    }
}


fun makeFullUrl(path: String) = "https://image.tmdb.org/t/p/w500${path}"