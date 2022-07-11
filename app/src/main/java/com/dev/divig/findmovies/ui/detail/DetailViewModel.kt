package com.dev.divig.findmovies.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dev.divig.findmovies.data.FindMoviesRepository
import com.dev.divig.findmovies.data.source.local.entity.MovieEntity
import com.dev.divig.findmovies.data.source.local.entity.TvShowsEntity
import com.dev.divig.findmovies.utils.Constant
import com.dev.divig.findmovies.vo.Resource

class DetailViewModel(private val findMoviesRepository: FindMoviesRepository) : ViewModel() {
    private lateinit var movieDetail: LiveData<Resource<MovieEntity>>
    private lateinit var tvShowDetail: LiveData<Resource<TvShowsEntity>>

    fun setMovie(id: Int, code: Int) {
        when (code) {
            Constant.CODE_MOVIE -> movieDetail = findMoviesRepository.getMovieDetail(id)
            Constant.CODE_TV -> tvShowDetail = findMoviesRepository.getTvShowsDetail(id)
        }
    }

    fun getMovieDetail() = movieDetail

    fun getTvShowDetail() = tvShowDetail

    fun setFavoriteMovie() {
        val movieResource = movieDetail.value
        if (movieResource?.data != null) {
            val newState = !movieResource.data.isFavorite
            findMoviesRepository.setFavoriteMovie(movieResource.data, newState)
        }
    }

    fun setFavoriteTvShow() {
        val tvShowResource = tvShowDetail.value
        if (tvShowResource?.data != null) {
            val newState = !tvShowResource.data.isFavorite
            findMoviesRepository.setFavoriteTvShow(tvShowResource.data, newState)
        }
    }
}