package com.dev.divig.findmovies.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dev.divig.findmovies.data.source.local.entity.MovieEntity
import com.dev.divig.findmovies.data.source.local.entity.TvShowsEntity
import com.dev.divig.findmovies.data.source.local.room.FindMoviesDao
import com.dev.divig.findmovies.utils.Constant
import com.dev.divig.findmovies.utils.SortUtils

class LocalDataSource(private val findMoviesDao: FindMoviesDao) {
    fun insertMovies(movies: List<MovieEntity>) = findMoviesDao.insertMovies(movies)

    fun updateMovie(movie: MovieEntity) = findMoviesDao.updateMovie(movie)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        findMoviesDao.updateMovie(movie)
    }

    fun getAllMovies(sort: String): DataSource.Factory<Int, MovieEntity> = findMoviesDao.getMovies(
        SortUtils.getSortedQuery(sort, Constant.TB_MOVIE)
    )

    fun getMovieById(id: Int): LiveData<MovieEntity> = findMoviesDao.getMovieById(id)

    fun getFavMovies(): DataSource.Factory<Int, MovieEntity> = findMoviesDao.getFavMovies()

    fun insertTvShows(tvShows: List<TvShowsEntity>) = findMoviesDao.insertTvShows(tvShows)

    fun updateTvShow(tvShow: TvShowsEntity) = findMoviesDao.updateTvShow(tvShow)

    fun setFavoriteTvShow(tvShow: TvShowsEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        findMoviesDao.updateTvShow(tvShow)
    }

    fun getAllTvShows(sort: String): DataSource.Factory<Int, TvShowsEntity> =
        findMoviesDao.getTvShows(SortUtils.getSortedQuery(sort, Constant.TB_TV_SHOW))

    fun getTvShowById(id: Int): LiveData<TvShowsEntity> = findMoviesDao.getTvShowById(id)

    fun getFavTvShows(): DataSource.Factory<Int, TvShowsEntity> = findMoviesDao.getFavTvShows()

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(findMoviesDao: FindMoviesDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(findMoviesDao)
    }
}