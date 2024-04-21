package com.feature.movie.data.repo

import com.core.network.dataproviders.MovieDataProviders
import com.feature.moive.domain.model.Movie
import com.feature.moive.domain.repo.MovieRepository
import com.feature.movie.data.mapper.toDomainMovieList
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(private val movieDataProvider: MovieDataProviders) :
    MovieRepository {
    override suspend fun getMovieList(apikey: String, q: String): List<Movie> {
        return movieDataProvider.getMovieList(apiKey = apikey, q = q).toDomainMovieList()
    }
}