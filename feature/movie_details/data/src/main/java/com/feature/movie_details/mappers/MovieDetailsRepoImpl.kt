package com.feature.movie_details.mappers

import com.core.network.dataproviders.MovieDataProviders
import com.feature.movie_details.domain.model.MovieDetails
import com.feature.movie_details.domain.repository.MovieDetailRepo
import javax.inject.Inject

class MovieDetailsRepoImpl @Inject constructor(private val movieDataProviders: MovieDataProviders) :
    MovieDetailRepo {
    override suspend fun getMovieDetails(id: String, apikey: String): MovieDetails {
        return movieDataProviders.getMovieDetails(id, apikey).toDomain()
    }
}