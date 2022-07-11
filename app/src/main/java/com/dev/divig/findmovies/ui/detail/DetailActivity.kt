package com.dev.divig.findmovies.ui.detail

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.dev.divig.findmovies.R
import com.dev.divig.findmovies.data.source.local.entity.MovieEntity
import com.dev.divig.findmovies.data.source.local.entity.TvShowsEntity
import com.dev.divig.findmovies.databinding.ActivityDetailBinding
import com.dev.divig.findmovies.databinding.LayoutDetailMovieBinding
import com.dev.divig.findmovies.databinding.LayoutDetailPlaceholderBinding
import com.dev.divig.findmovies.utils.Constant
import com.dev.divig.findmovies.utils.Utils
import com.dev.divig.findmovies.viewmodel.ViewModelFactory
import com.dev.divig.findmovies.vo.Status
import com.google.android.material.appbar.AppBarLayout

class DetailActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailMovieBinding: LayoutDetailMovieBinding
    private lateinit var detailPlaceholderBinding: LayoutDetailPlaceholderBinding

    private var requestCode: Int = 0
    private var isOnProgress: Boolean = false
    private var isHideFab: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        detailMovieBinding = binding.detailMovie
        detailPlaceholderBinding = binding.detailPlaceholder
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.appBarLayout.addOnOffsetChangedListener(this)

        init()
    }

    private fun init() {
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val codeId = extras.getInt(Constant.EXTRA_ID)
            requestCode = extras.getInt(Constant.EXTRA_CODE)

            viewModel.setMovie(codeId, requestCode)
            when (requestCode) {
                Constant.CODE_MOVIE -> {
                    viewModel.getMovieDetail().observe(this, { response ->
                        when (response.status) {
                            Status.LOADING -> onProgress(true)
                            Status.SUCCESS -> {
                                if (response.data != null) {
                                    onProgress(false)
                                    populateMovie(response.data)
                                }
                            }
                            Status.ERROR -> {
                                onProgress(false)
                                Utils.showToast(this, getString(R.string.message_failure))
                            }
                        }
                    })
                }
                Constant.CODE_TV -> {
                    viewModel.getTvShowDetail().observe(this, { response ->
                        when (response.status) {
                            Status.LOADING -> onProgress(true)
                            Status.SUCCESS -> {
                                if (response.data != null) {
                                    onProgress(false)
                                    populateTvShows(response.data)
                                }
                            }
                            Status.ERROR -> {
                                onProgress(false)
                                Utils.showToast(this, getString(R.string.message_failure))
                            }
                        }
                    })
                }
            }
        }

        binding.fabAddToFavorite.setOnClickListener {
            when (requestCode) {
                Constant.CODE_MOVIE -> viewModel.setFavoriteMovie()
                Constant.CODE_TV -> viewModel.setFavoriteTvShow()
            }
        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        val date =
            if (movieEntity.releaseDate.isNullOrEmpty()) getString(R.string.empty_date) else movieEntity.releaseDate

        val title = movieEntity.title
        binding.toolbarLayout.title = title

        detailMovieBinding.tvGenre.text = movieEntity.genres

        detailMovieBinding.tvDate.text = date
        detailMovieBinding.tvRuntime.text = convertRuntime(movieEntity.runtime)
        detailMovieBinding.tvOverview.text = movieEntity.overview
        setFabFavorite(movieEntity.isFavorite)

        val imgPosterUrl = Constant.IMAGE_URL + movieEntity.posterPath
        val imgBackdropUrl = Constant.IMAGE_URL + movieEntity.backdropPath
        detailMovieBinding.imgPoster.load(imgPosterUrl) {
            placeholder(R.drawable.ic_loading)
            error(R.drawable.ic_error)
        }
        binding.imgCollapsing.load(imgBackdropUrl) {
            placeholder(R.drawable.ic_loading)
            error(R.drawable.ic_error)
        }
    }

    private fun populateTvShows(tvShowsEntity: TvShowsEntity) {
        val title = tvShowsEntity.title
        binding.toolbarLayout.title = title

        detailMovieBinding.tvGenre.text = tvShowsEntity.genres

        val date =
            if (tvShowsEntity.releaseDate.isNullOrEmpty()) getString(R.string.empty_date) else tvShowsEntity.releaseDate
        detailMovieBinding.tvDate.text = date
        detailMovieBinding.tvRuntime.text = convertRuntime(tvShowsEntity.runtime)
        detailMovieBinding.tvOverview.text = tvShowsEntity.overview
        setFabFavorite(tvShowsEntity.isFavorite)

        val imgPosterUrl = Constant.IMAGE_URL + tvShowsEntity.posterPath
        val imgBackdropUrl = Constant.IMAGE_URL + tvShowsEntity.backdropPath
        detailMovieBinding.imgPoster.load(imgPosterUrl) {
            placeholder(R.drawable.ic_loading)
            error(R.drawable.ic_error)
        }
        binding.imgCollapsing.load(imgBackdropUrl) {
            placeholder(R.drawable.ic_loading)
            error(R.drawable.ic_error)
        }
    }

    private fun convertRuntime(runtime: Int): String {
        val hours = runtime / Constant.ONE_HOURS
        val minutes = runtime % Constant.ONE_HOURS
        return if (runtime >= Constant.ONE_HOURS) {
            "${hours}h ${minutes}m"
        } else {
            "${minutes}m"
        }
    }

    private fun onProgress(isProgress: Boolean) {
        if (isProgress) {
            binding.progressBar.visibility = View.VISIBLE

            hideFab(true)
            detailMovieBinding.layoutDetailMovie.visibility = View.GONE
            detailPlaceholderBinding.layoutPlaceholder.visibility = View.VISIBLE
            isOnProgress = isProgress
        } else {
            binding.progressBar.visibility = View.GONE

            hideFab(false)
            detailMovieBinding.layoutDetailMovie.visibility = View.VISIBLE
            detailPlaceholderBinding.layoutPlaceholder.visibility = View.GONE
            isOnProgress = isProgress
        }
    }

    private fun hideFab(isHide: Boolean) {
        val fab = binding.fabAddToFavorite
        val fabOpenAnim = AnimationUtils.loadAnimation(this, R.anim.slide_from_bottom_to_center)
        val fabCloseAnim = AnimationUtils.loadAnimation(this, R.anim.slide_from_center_to_bottom)
        if (isHide) {
            fab.animation = fabCloseAnim
            fab.visibility = View.GONE
        } else {
            fab.animation = fabOpenAnim
            fab.visibility = View.VISIBLE
        }
    }

    private fun setFabFavorite(state: Boolean) {
        if (state) {
            binding.fabAddToFavorite.load(R.drawable.ic_favorite_filled_24dp)
        } else {
            binding.fabAddToFavorite.load(R.drawable.ic_favorite_outlined_24dp)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (!isOnProgress) {
            if (verticalOffset == 0) {
                hideFab(false)
                isHideFab = true
            } else {
                if (isHideFab) {
                    hideFab(true)
                    isHideFab = false
                }
            }
        }
    }
}