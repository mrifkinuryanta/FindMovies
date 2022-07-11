package com.dev.divig.findmovies.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dev.divig.findmovies.data.FindMoviesRepository
import com.dev.divig.findmovies.di.Injection
import com.dev.divig.findmovies.ui.detail.DetailViewModel
import com.dev.divig.findmovies.ui.favorite.movie.FavoriteMovieViewModel
import com.dev.divig.findmovies.ui.favorite.tvshows.FavoriteTvShowsViewModel
import com.dev.divig.findmovies.ui.movie.MovieViewModel
import com.dev.divig.findmovies.ui.tvshows.TvShowsViewModel

class ViewModelFactory private constructor(private val mFindMoviesRepository: FindMoviesRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mFindMoviesRepository) as T
            }
            modelClass.isAssignableFrom(TvShowsViewModel::class.java) -> {
                TvShowsViewModel(mFindMoviesRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mFindMoviesRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java) -> {
                FavoriteMovieViewModel(mFindMoviesRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteTvShowsViewModel::class.java) -> {
                FavoriteTvShowsViewModel(mFindMoviesRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }
}