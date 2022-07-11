package com.dev.divig.findmovies.ui.favorite.tvshows

import androidx.lifecycle.ViewModel
import com.dev.divig.findmovies.data.FindMoviesRepository

class FavoriteTvShowsViewModel(private val findMoviesRepository: FindMoviesRepository) :
    ViewModel() {

    fun getFavoriteTvShows() = findMoviesRepository.getFavoriteTvShows()
}