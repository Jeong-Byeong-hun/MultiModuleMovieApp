package com.example.multimodulemovieapp.navigation

import com.feature.movie.ui.navigation.MovieApi
import com.feature.movie_details.ui.navigation.MovieDetailsApi
import com.feature.playing_movie.ui.NowMoviePlayingApi

data class NavigationProviders(
    val movieApi: MovieApi,
    val movieDetailsApi: MovieDetailsApi,
    val nowPlayingMovieApi: NowMoviePlayingApi,
)
