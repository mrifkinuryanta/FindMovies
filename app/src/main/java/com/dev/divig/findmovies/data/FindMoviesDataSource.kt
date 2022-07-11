package com.dev.divig.findmovies.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dev.divig.findmovies.data.source.local.entity.MovieEntity
import com.dev.divig.findmovies.data.source.local.entity.TvShowsEntity
import com.dev.divig.findmovies.vo.Resource

interface FindMoviesDataSource {

    fun getMovies(sort: String): LiveData<Resource<PagedList<MovieEntity>>>

    fun getMovieDetail(movieId: Int): LiveData<Resource<MovieEntity>>

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>

    fun setFavoriteMovie(movieEntity: MovieEntity, state: Boolean)

    fun getTvShows(sort: String): LiveData<Resource<PagedList<TvShowsEntity>>>

    fun getTvShowsDetail(tvShowId: Int): LiveData<Resource<TvShowsEntity>>

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowsEntity>>

    fun setFavoriteTvShow(tvShowsEntity: TvShowsEntity, state: Boolean)
}