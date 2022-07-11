package com.dev.divig.findmovies.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dev.divig.findmovies.data.source.remote.response.movie.MovieDetailResponse
import com.dev.divig.findmovies.data.source.remote.response.movie.MovieItem
import com.dev.divig.findmovies.data.source.remote.response.movie.MovieResponse
import com.dev.divig.findmovies.data.source.remote.response.tv.TvResponse
import com.dev.divig.findmovies.data.source.remote.response.tv.TvShowsDetailResponse
import com.dev.divig.findmovies.data.source.remote.response.tv.TvShowsItem
import com.dev.divig.findmovies.network.ApiConfig
import com.dev.divig.findmovies.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    fun getMovies(): LiveData<ApiResponse<List<MovieItem>>> {
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<MovieItem>>>()
        val client = ApiConfig.getApiService().getMovies()
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                resultMovies.value =
                    ApiResponse.success(response.body()?.results as List<MovieItem>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getMovies onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
        return resultMovies
    }

    fun getTvShows(): LiveData<ApiResponse<List<TvShowsItem>>> {
        EspressoIdlingResource.increment()
        val resultTvShows = MutableLiveData<ApiResponse<List<TvShowsItem>>>()
        val client = ApiConfig.getApiService().getTvShows()
        client.enqueue(object : Callback<TvResponse> {
            override fun onResponse(call: Call<TvResponse>, response: Response<TvResponse>) {
                resultTvShows.value =
                    ApiResponse.success(response.body()?.results as List<TvShowsItem>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getTvShows onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
        return resultTvShows
    }

    fun getMovieDetail(movieId: String): LiveData<ApiResponse<MovieDetailResponse>> {
        EspressoIdlingResource.increment()
        val resultMovieDetail = MutableLiveData<ApiResponse<MovieDetailResponse>>()
        val client = ApiConfig.getApiService().getMovieDetail(movieId)
        client.enqueue(object : Callback<MovieDetailResponse> {
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>
            ) {
                resultMovieDetail.value =
                    ApiResponse.success(response.body() as MovieDetailResponse)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getMovieDetail onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
        return resultMovieDetail
    }

    fun getTvShowsDetail(tvShowsId: String): LiveData<ApiResponse<TvShowsDetailResponse>> {
        EspressoIdlingResource.increment()
        val resultTvShowsDetail = MutableLiveData<ApiResponse<TvShowsDetailResponse>>()
        val client = ApiConfig.getApiService().getTvShowsDetail(tvShowsId)
        client.enqueue(object : Callback<TvShowsDetailResponse> {
            override fun onResponse(
                call: Call<TvShowsDetailResponse>,
                response: Response<TvShowsDetailResponse>
            ) {
                resultTvShowsDetail.value =
                    ApiResponse.success(response.body() as TvShowsDetailResponse)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowsDetailResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getTvShowsDetail onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
        return resultTvShowsDetail
    }

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }
}