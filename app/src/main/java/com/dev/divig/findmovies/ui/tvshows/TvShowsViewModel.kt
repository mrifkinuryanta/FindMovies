package com.dev.divig.findmovies.ui.tvshows

import androidx.lifecycle.ViewModel
import com.dev.divig.findmovies.data.FindMoviesRepository

class TvShowsViewModel(private val findMoviesRepository: FindMoviesRepository) : ViewModel() {

    fun getTvShows(sort: String) = findMoviesRepository.getTvShows(sort)
}