package com.example.multimodulemovieapp.navigation

import com.feature.movie.ui.navigation.MovieApi
import com.feature.movie_details.ui.navigation.MovieDetailsApi

data class NavigationProviders(
    val movieApi: MovieApi,
    val movieDetailsApi: MovieDetailsApi
)
