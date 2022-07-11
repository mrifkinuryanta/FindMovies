package com.dev.divig.findmovies.ui.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.dev.divig.findmovies.R
import com.dev.divig.findmovies.data.source.local.entity.TvShowsEntity
import com.dev.divig.findmovies.databinding.ItemsPosterBinding
import com.dev.divig.findmovies.utils.Constant
import com.dev.divig.findmovies.utils.Utils

class TvShowsAdapter :
    PagedListAdapter<TvShowsEntity, TvShowsAdapter.TvShowsViewHolder>(DIFF_CALLBACK) {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        val binding =
            ItemsPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

    inner class TvShowsViewHolder(private val binding: ItemsPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TvShowsEntity) {
            with(itemView) {
                binding.itemTvTitle.text = tvShows.title

                val rating = tvShows.voteAverage * Constant.TEN
                binding.itemTvRating.text = ("${rating.toInt()}%")
                binding.pbRating.progress = rating.toInt()

                val date =
                    if (tvShows.releaseDate.isNullOrEmpty()) resources.getString(R.string.empty_date) else Utils.splitDate(
                        tvShows.releaseDate
                    )
                binding.itemTvDate.text = date

                setOnClickListener {
                    onItemClickCallback?.onItemClicked(tvShows)
                }

                val imgUrl = Constant.IMAGE_URL + tvShows.posterPath
                binding.itemImgPoster.load(imgUrl) {
                    placeholder(R.drawable.ic_loading)
                    error(R.drawable.ic_error)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TvShowsEntity)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowsEntity>() {
            override fun areItemsTheSame(oldItem: TvShowsEntity, newItem: TvShowsEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: TvShowsEntity,
                newItem: TvShowsEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}