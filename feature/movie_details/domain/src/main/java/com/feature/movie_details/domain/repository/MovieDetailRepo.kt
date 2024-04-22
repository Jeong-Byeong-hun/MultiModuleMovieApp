package com.feature.movie_details.domain.repository

import com.feature.movie_details.domain.model.MovieDetails

interface MovieDetailRepo {
    suspend fun getMovieDetails(id:String, apikey:String): MovieDetails
}