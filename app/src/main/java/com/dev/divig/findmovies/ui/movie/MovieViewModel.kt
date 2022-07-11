package com.dev.divig.findmovies.ui.movie

import androidx.lifecycle.ViewModel
import com.dev.divig.findmovies.data.FindMoviesRepository

class MovieViewModel(private val findMoviesRepository: FindMoviesRepository) : ViewModel() {

    fun getMovies(sort: String) = findMoviesRepository.getMovies(sort)
}