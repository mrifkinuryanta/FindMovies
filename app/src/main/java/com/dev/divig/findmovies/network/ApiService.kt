package com.dev.divig.findmovies.network

import com.dev.divig.findmovies.data.source.remote.response.movie.MovieDetailResponse
import com.dev.divig.findmovies.data.source.remote.response.movie.MovieResponse
import com.dev.divig.findmovies.data.source.remote.response.tv.TvResponse
import com.dev.divig.findmovies.data.source.remote.response.tv.TvShowsDetailResponse
import com.dev.divig.findmovies.utils.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    fun getMovies(
        @Query("api_key") apiKey: String = Constant.API_KEY
    ): Call<MovieResponse>

    @GET("movie/{id}")
    fun getMovieDetail(
        @Path("id") id: String,
        @Query("api_key") apiKey: String = Constant.API_KEY
    ): Call<MovieDetailResponse>

    @GET("discover/tv")
    fun getTvShows(
        @Query("api_key") apiKey: String = Constant.API_KEY
    ): Call<TvResponse>

    @GET("tv/{id}")
    fun getTvShowsDetail(
        @Path("id") id: String,
        @Query("api_key") apiKey: String = Constant.API_KEY
    ): Call<TvShowsDetailResponse>
}