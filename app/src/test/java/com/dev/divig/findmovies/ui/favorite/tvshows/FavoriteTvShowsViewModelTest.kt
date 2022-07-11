package com.dev.divig.findmovies.ui.favorite.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dev.divig.findmovies.data.FindMoviesRepository
import com.dev.divig.findmovies.data.source.local.entity.TvShowsEntity
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
class FavoriteTvShowsViewModelTest {
    private lateinit var viewModel: FavoriteTvShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var findMoviesRepository: FindMoviesRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowsEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowsEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteTvShowsViewModel(findMoviesRepository)
    }

    @Test
    fun getFavoriteTvShows() {
        val dummyTvShow = pagedList
        `when`(dummyTvShow.size).thenReturn(5)
        val tvShows = MutableLiveData<PagedList<TvShowsEntity>>()
        tvShows.value = dummyTvShow

        `when`(findMoviesRepository.getFavoriteTvShows()).thenReturn(tvShows)
        val tvShow = viewModel.getFavoriteTvShows().value
        verify(findMoviesRepository).getFavoriteTvShows()
        assertNotNull(tvShow)
        assertEquals(5, tvShow?.size)

        viewModel.getFavoriteTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}