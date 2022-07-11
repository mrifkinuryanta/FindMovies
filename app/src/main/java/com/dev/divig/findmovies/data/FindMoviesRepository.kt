package com.dev.divig.findmovies.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dev.divig.findmovies.data.source.local.LocalDataSource
import com.dev.divig.findmovies.data.source.local.entity.MovieEntity
import com.dev.divig.findmovies.data.source.local.entity.TvShowsEntity
import com.dev.divig.findmovies.data.source.remote.ApiResponse
import com.dev.divig.findmovies.data.source.remote.RemoteDataSource
import com.dev.divig.findmovies.data.source.remote.response.movie.MovieDetailResponse
import com.dev.divig.findmovies.data.source.remote.response.movie.MovieItem
import com.dev.divig.findmovies.data.source.remote.response.tv.TvShowsDetailResponse
import com.dev.divig.findmovies.data.source.remote.response.tv.TvShowsItem
import com.dev.divig.findmovies.utils.AppExecutors
import com.dev.divig.findmovies.vo.Resource

class FindMoviesRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    FindMoviesDataSource {

    override fun getMovies(sort: String): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPrefetchDistance(10)
                    .setPageSize(10)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllMovies(sort), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieItem>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(data: List<MovieItem>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        id = response.id,
                        title = response.title,
                        overview = response.overview,
                        genres = "",
                        releaseDate = response.releaseDate,
                        runtime = 0,
                        voteAverage = response.voteAverage,
                        posterPath = response.posterPath,
                        backdropPath = response.backdropPath,
                        isFavorite = false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getMovieDetail(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MovieDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> = localDataSource.getMovieById(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data != null && data.runtime == 0 && data.genres == ""

            override fun createCall(): LiveData<ApiResponse<MovieDetailResponse>> =
                remoteDataSource.getMovieDetail(movieId.toString())

            override fun saveCallResult(data: MovieDetailResponse) {
                val genres = StringBuilder().append("")

                for (i in data.genres.indices) {
                    if (i < data.genres.size - 1) {
                        genres.append("${data.genres[i].name}, ")
                    } else {
                        genres.append(data.genres[i].name)
                    }
                }

                val movie = MovieEntity(
                    id = data.id,
                    title = data.title,
                    overview = data.overview,
                    genres = genres.toString(),
                    releaseDate = data.releaseDate,
                    runtime = data.runtime,
                    voteAverage = data.voteAverage,
                    posterPath = data.posterPath,
                    backdropPath = data.backdropPath,
                    isFavorite = false
                )
                localDataSource.updateMovie(movie)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPrefetchDistance(10)
            .setPageSize(10)
            .build()

        return LivePagedListBuilder(localDataSource.getFavMovies(), config).build()
    }

    override fun setFavoriteMovie(movieEntity: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteMovie(movieEntity, state)
        }
    }

    override fun getTvShows(sort: String): LiveData<Resource<PagedList<TvShowsEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvShowsEntity>, List<TvShowsItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShowsEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPrefetchDistance(10)
                    .setPageSize(10)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllTvShows(sort), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowsEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowsItem>>> =
                remoteDataSource.getTvShows()

            override fun saveCallResult(data: List<TvShowsItem>) {
                val movieList = ArrayList<TvShowsEntity>()
                for (response in data) {
                    val movie = TvShowsEntity(
                        id = response.id,
                        title = response.name,
                        overview = response.overview,
                        genres = "",
                        releaseDate = response.firstAirDate,
                        runtime = 0,
                        voteAverage = response.voteAverage,
                        posterPath = response.posterPath,
                        backdropPath = response.backdropPath,
                        isFavorite = false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertTvShows(movieList)
            }
        }.asLiveData()
    }

    override fun getTvShowsDetail(tvShowId: Int): LiveData<Resource<TvShowsEntity>> {
        return object : NetworkBoundResource<TvShowsEntity, TvShowsDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowsEntity> =
                localDataSource.getTvShowById(tvShowId)

            override fun shouldFetch(data: TvShowsEntity?): Boolean =
                data != null && data.runtime == 0 && data.genres == ""

            override fun createCall(): LiveData<ApiResponse<TvShowsDetailResponse>> =
                remoteDataSource.getTvShowsDetail(tvShowId.toString())

            override fun saveCallResult(data: TvShowsDetailResponse) {
                val genres = StringBuilder().append("")

                for (i in data.genres.indices) {
                    if (i < data.genres.size - 1) {
                        genres.append("${data.genres[i].name}, ")
                    } else {
                        genres.append(data.genres[i].name)
                    }
                }

                val tvShow = TvShowsEntity(
                    id = data.id,
                    title = data.name,
                    overview = data.overview,
                    genres = genres.toString(),
                    releaseDate = data.firstAirDate,
                    runtime = data.episodeRunTime.first(),
                    voteAverage = data.voteAverage,
                    posterPath = data.posterPath,
                    backdropPath = data.backdropPath,
                    isFavorite = false
                )
                localDataSource.updateTvShow(tvShow)
            }
        }.asLiveData()
    }

    override fun getFavoriteTvShows(): LiveData<PagedList<TvShowsEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPrefetchDistance(10)
            .setPageSize(10)
            .build()

        return LivePagedListBuilder(localDataSource.getFavTvShows(), config).build()
    }

    override fun setFavoriteTvShow(tvShowsEntity: TvShowsEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteTvShow(tvShowsEntity, state)
        }
    }

    companion object {
        @Volatile
        private var instance: FindMoviesRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localDataSource: LocalDataSource,
            appExecutors: AppExecutors
        ): FindMoviesRepository =
            instance ?: synchronized(this) {
                instance ?: FindMoviesRepository(remoteData, localDataSource, appExecutors)
            }
    }
}