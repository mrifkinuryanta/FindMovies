package com.dev.divig.findmovies.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.dev.divig.findmovies.R
import com.dev.divig.findmovies.data.source.local.entity.MovieEntity
import com.dev.divig.findmovies.databinding.ItemsPosterBinding
import com.dev.divig.findmovies.utils.Constant
import com.dev.divig.findmovies.utils.Utils

class MovieAdapter : PagedListAdapter<MovieEntity, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding =
            ItemsPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    inner class MovieViewHolder(private val binding: ItemsPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(itemView) {
                binding.itemTvTitle.text = movie.title

                val rating = movie.voteAverage * Constant.TEN
                binding.itemTvRating.text = ("${rating.toInt()}%")
                binding.pbRating.progress = rating.toInt()

                val date =
                    if (movie.releaseDate.isNullOrEmpty()) resources.getString(R.string.empty_date) else Utils.splitDate(
                        movie.releaseDate
                    )
                binding.itemTvDate.text = date

                setOnClickListener {
                    onItemClickCallback?.onItemClicked(movie)
                }

                val imgUrl = Constant.IMAGE_URL + movie.posterPath
                binding.itemImgPoster.load(imgUrl) {
                    placeholder(R.drawable.ic_loading)
                    error(R.drawable.ic_error)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MovieEntity)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}