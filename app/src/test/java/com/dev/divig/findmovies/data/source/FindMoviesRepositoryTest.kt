package com.dev.divig.findmovies.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dev.divig.findmovies.data.source.local.LocalDataSource
import com.dev.divig.findmovies.data.source.local.entity.MovieEntity
import com.dev.divig.findmovies.data.source.local.entity.TvShowsEntity
import com.dev.divig.findmovies.data.source.remote.RemoteDataSource
import com.dev.divig.findmovies.utils.*
import com.dev.divig.findmovies.vo.Resource
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.util.concurrent.Executor

@Suppress("UNCHECKED_CAST")
class FindMoviesRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)

    private val executor = Executor { it.run() }
    private val appExecutors = AppExecutors(executor, executor, executor)
    private val findMoviesRepository = FakeFindMoviesRepository(remote, local, appExecutors)

    private val moviesResponse = DataDummy.getRemoteMovies()
    private val movieId = moviesResponse[0].id
    private val moviesDetail = DataDummy.getRemoteDetailMovie()

    private val tvShowsResponse = DataDummy.getRemoteTvShows()
    private val tvShowsId = tvShowsResponse[0].id
    private val tvShowsDetail = DataDummy.getRemoteDetailTvShows()

    @Test
    fun getMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies(Constant.VOTE_RANDOM)).thenReturn(dataSourceFactory)
        findMoviesRepository.getMovies(Constant.VOTE_RANDOM)

        val response = Resource.success(PagedListUtil.mockPagedList(DataDummy.getMovies()))
        verify(local).getAllMovies(Constant.VOTE_RANDOM)

        assertNotNull(response.data)
        assertEquals(moviesResponse.size, response.data?.size)
    }

    @Test
    fun getMovieDetail() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = DataDummy.getMovieDetail()
        `when`(local.getMovieById(movieId)).thenReturn(dummyMovie)

        val response = LiveDataTestUtil.getValue(findMoviesRepository.getMovieDetail(movieId))
        verify(local).getMovieById(movieId)

        assertNotNull(response.data)
        assertEquals(moviesDetail.id, response.data?.id)
    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavMovies()).thenReturn(dataSourceFactory)
        findMoviesRepository.getFavoriteMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.getMovies()))
        verify(local).getFavMovies()

        assertNotNull(movieEntities.data)
        assertEquals(moviesResponse.size, movieEntities.data?.size)
    }

    @Test
    fun setFavoriteMovie() {
        findMoviesRepository.setFavoriteMovie(DataDummy.getMovieDetail(), true)
        verify(local, times(1)).setFavoriteMovie(DataDummy.getMovieDetail(), true)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun getTvShows() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowsEntity>
        `when`(local.getAllTvShows(Constant.VOTE_RANDOM)).thenReturn(dataSourceFactory)
        findMoviesRepository.getTvShows(Constant.VOTE_RANDOM)

        val response = Resource.success(PagedListUtil.mockPagedList(DataDummy.getTvShows()))
        verify(local).getAllTvShows(Constant.VOTE_RANDOM)

        assertNotNull(response.data)
        assertEquals(tvShowsResponse.size, response.data?.size)
    }

    @Test
    fun getTvShowsDetail() {
        val dummyDetail = MutableLiveData<TvShowsEntity>()
        dummyDetail.value = DataDummy.getTvShowsDetail()
        `when`(local.getTvShowById(tvShowsId)).thenReturn(dummyDetail)

        val response = LiveDataTestUtil.getValue(findMoviesRepository.getTvShowsDetail(tvShowsId))
        verify(local).getTvShowById(tvShowsId)

        assertNotNull(response.data)
        assertEquals(tvShowsDetail.id, response.data?.id)
    }

    @Test
    fun getFavoriteTvShows() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowsEntity>
        `when`(local.getFavTvShows()).thenReturn(dataSourceFactory)
        findMoviesRepository.getFavoriteTvShows()

        val response = Resource.success(PagedListUtil.mockPagedList(DataDummy.getTvShows()))
        verify(local).getFavTvShows()

        assertNotNull(response.data)
        assertEquals(tvShowsResponse.size, response.data?.size)
    }

    @Test
    fun setFavoriteTvShow() {
        findMoviesRepository.setFavoriteTvShow(DataDummy.getTvShowsDetail(), true)
        verify(local, times(1)).setFavoriteTvShow(DataDummy.getTvShowsDetail(), true)
        verifyNoMoreInteractions(local)
    }
}