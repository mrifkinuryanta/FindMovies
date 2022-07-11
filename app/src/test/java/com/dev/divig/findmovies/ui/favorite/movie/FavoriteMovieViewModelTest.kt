package com.dev.divig.findmovies.ui.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dev.divig.findmovies.data.FindMoviesRepository
import com.dev.divig.findmovies.data.source.local.entity.MovieEntity
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteMovieViewModelTest {

    private lateinit var viewModel: FavoriteMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var findMoviesRepository: FindMoviesRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteMovieViewModel(findMoviesRepository)
    }

    @Test
    fun getFavoriteMovie() {
        val dummyMovie = pagedList
        `when`(dummyMovie.size).thenReturn(5)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyMovie

        `when`(findMoviesRepository.getFavoriteMovies()).thenReturn(movies)
        val movie = viewModel.getFavoriteMovie().value
        verify(findMoviesRepository).getFavoriteMovies()
        assertNotNull(movie)
        assertEquals(5, movie?.size)

        viewModel.getFavoriteMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}