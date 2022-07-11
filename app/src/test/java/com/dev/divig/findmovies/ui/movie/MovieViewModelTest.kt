package com.dev.divig.findmovies.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dev.divig.findmovies.data.FindMoviesRepository
import com.dev.divig.findmovies.data.source.local.entity.MovieEntity
import com.dev.divig.findmovies.utils.Constant
import com.dev.divig.findmovies.vo.Resource
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
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var findMoviesRepository: FindMoviesRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(findMoviesRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = Resource.success(pagedList)
        `when`(dummyMovies.data?.size).thenReturn(5)
        val movies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movies.value = dummyMovies

        `when`(findMoviesRepository.getMovies(Constant.VOTE_RANDOM)).thenReturn(movies)
        val response = viewModel.getMovies(Constant.VOTE_RANDOM).value?.data
        verify(findMoviesRepository).getMovies(Constant.VOTE_RANDOM)

        assertNotNull(response)
        assertEquals(5, response?.size)

        viewModel.getMovies(Constant.VOTE_RANDOM).observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}