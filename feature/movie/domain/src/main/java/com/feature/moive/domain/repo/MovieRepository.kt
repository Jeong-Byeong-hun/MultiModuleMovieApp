package com.feature.moive.domain.repo

import com.feature.moive.domain.model.Movie

interface MovieRepository {
    suspend fun getMovieList(apikey:String,q:String): List<Movie>
}