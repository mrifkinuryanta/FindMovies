package com.dev.divig.findmovies.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import com.dev.divig.findmovies.data.source.local.entity.MovieEntity
import com.dev.divig.findmovies.data.source.local.entity.TvShowsEntity

@Dao
interface FindMoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @RawQuery(observedEntities = [MovieEntity::class])
    fun getMovies(query: SimpleSQLiteQuery): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tb_movie WHERE id = :id")
    fun getMovieById(id: Int): LiveData<MovieEntity>

    @Query("SELECT * FROM tb_movie WHERE isFavorite = 1")
    fun getFavMovies(): DataSource.Factory<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowsEntity>)

    @Update
    fun updateTvShow(tvShow: TvShowsEntity)

    @RawQuery(observedEntities = [TvShowsEntity::class])
    fun getTvShows(query: SimpleSQLiteQuery): DataSource.Factory<Int, TvShowsEntity>

    @Query("SELECT * FROM tb_tv_show WHERE id = :id")
    fun getTvShowById(id: Int): LiveData<TvShowsEntity>

    @Query("SELECT * FROM tb_tv_show WHERE isFavorite = 1")
    fun getFavTvShows(): DataSource.Factory<Int, TvShowsEntity>
}