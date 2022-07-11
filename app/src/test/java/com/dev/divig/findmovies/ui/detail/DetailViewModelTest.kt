package com.dev.divig.findmovies.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dev.divig.findmovies.data.FindMoviesRepository
import com.dev.divig.findmovies.data.source.local.entity.MovieEntity
import com.dev.divig.findmovies.data.source.local.entity.TvShowsEntity
import com.dev.divig.findmovies.utils.Constant
import com.dev.divig.findmovies.utils.DataDummy
import com.dev.divig.findmovies.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.getMovieDetail()
    private val dummyTvShows = DataDummy.getTvShowsDetail()

    private val movieId = dummyMovie.id
    private val tvShowsId = dummyTvShows.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var findMoviesRepository: FindMoviesRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvShowsObserver: Observer<Resource<TvShowsEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(findMoviesRepository)
    }

    @Test
    fun testGetDetailMovies() {
        val dummyMovie = Resource.success(DataDummy.getMovieDetail())
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovie

        `when`(findMoviesRepository.getMovieDetail(movieId)).thenReturn(movie)

        viewModel.setMovie(movieId, Constant.CODE_MOVIE)
        viewModel.getMovieDetail().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun testGetDetailTvShows() {
        val dummyTvShows = Resource.success(DataDummy.getTvShowsDetail())
        val tvShows = MutableLiveData<Resource<TvShowsEntity>>()
        tvShows.value = dummyTvShows

        `when`(findMoviesRepository.getTvShowsDetail(tvShowsId)).thenReturn(tvShows)

        viewModel.setMovie(tvShowsId, Constant.CODE_TV)
        viewModel.getTvShowDetail().observeForever(tvShowsObserver)
        verify(tvShowsObserver).onChanged(dummyTvShows)
    }

    @Test
    fun setFavoriteMovie() {
        val dummyMovieDetail = Resource.success(DataDummy.getMovieDetail())
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovieDetail

        `when`(findMoviesRepository.getMovieDetail(movieId)).thenReturn(movie)

        viewModel.setMovie(movieId, Constant.CODE_MOVIE)
        viewModel.setFavoriteMovie()
        verify(findMoviesRepository).setFavoriteMovie(movie.value!!.data as MovieEntity, true)
        verifyNoMoreInteractions(movieObserver)
    }

    @Test
    fun setFavoriteTvShow() {
        val dummyDetailTvShow = Resource.success(DataDummy.getTvShowsDetail())
        val tvShows = MutableLiveData<Resource<TvShowsEntity>>()
        tvShows.value = dummyDetailTvShow

        `when`(findMoviesRepository.getTvShowsDetail(tvShowsId)).thenReturn(tvShows)

        viewModel.setMovie(tvShowsId, Constant.CODE_TV)
        viewModel.setFavoriteTvShow()
        verify(findMoviesRepository).setFavoriteTvShow(tvShows.value!!.data as TvShowsEntity, true)
        verifyNoMoreInteractions(tvShowsObserver)
    }
}