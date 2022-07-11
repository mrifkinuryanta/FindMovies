package com.dev.divig.findmovies.ui.favorite.movie

import androidx.lifecycle.ViewModel
import com.dev.divig.findmovies.data.FindMoviesRepository

class FavoriteMovieViewModel(private val findMoviesRepository: FindMoviesRepository) : ViewModel() {

    fun getFavoriteMovie() = findMoviesRepository.getFavoriteMovies()
}