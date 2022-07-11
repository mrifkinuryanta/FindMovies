package com.dev.divig.findmovies.ui.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dev.divig.findmovies.data.FindMoviesRepository
import com.dev.divig.findmovies.data.source.local.entity.TvShowsEntity
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
class TvShowsViewModelTest {

    private lateinit var viewModel: TvShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var findMoviesRepository: FindMoviesRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowsEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowsEntity>

    @Before
    fun setUp() {
        viewModel = TvShowsViewModel(findMoviesRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShows = Resource.success(pagedList)
        `when`(dummyTvShows.data?.size).thenReturn(5)
        val tvShows = MutableLiveData<Resource<PagedList<TvShowsEntity>>>()
        tvShows.value = dummyTvShows

        `when`(findMoviesRepository.getTvShows(Constant.VOTE_RANDOM)).thenReturn(tvShows)
        val response = viewModel.getTvShows(Constant.VOTE_RANDOM).value?.data
        verify(findMoviesRepository).getTvShows(Constant.VOTE_RANDOM)

        assertNotNull(response)
        assertEquals(5, response?.size)

        viewModel.getTvShows(Constant.VOTE_RANDOM).observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}