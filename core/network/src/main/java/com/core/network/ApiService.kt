package com.core.network

import com.core.network.model.MovieDetailsDTO
import com.core.network.model.MovieListResponse
import com.core.network.model.NowPlayingResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    //https://api.themoviedb.org/3/movie/{id}/query=harry&include_adult=false&language=en-US&page=1

    @GET("3/search/movie")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String,
        @Query("query") q: String,
        @Query("language") language: String = "ko-KR"
    ): MovieListResponse


    @GET("3/movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "ko-KR"
    ): MovieDetailsDTO

    @GET("3/movie/now_playing")
    suspend fun getNowPlaying(
        @Query("language") language: String = "ko-KR",
        @Query("page") page: Int = 1,
        @Query("region") region: String = "KR",
        @Query("api_key") apiKey: String = "6e75acc6bb8cb7c2e71901cd807914b5",
    ): NowPlayingResponse

}