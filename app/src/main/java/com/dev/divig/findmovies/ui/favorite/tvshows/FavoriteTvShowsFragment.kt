package com.dev.divig.findmovies.ui.favorite.tvshows

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dev.divig.findmovies.data.source.local.entity.TvShowsEntity
import com.dev.divig.findmovies.databinding.FragmentFavoriteTvShowsBinding
import com.dev.divig.findmovies.ui.detail.DetailActivity
import com.dev.divig.findmovies.utils.Constant
import com.dev.divig.findmovies.viewmodel.ViewModelFactory

class FavoriteTvShowsFragment : Fragment() {
    private lateinit var viewModel: FavoriteTvShowsViewModel
    private lateinit var favoriteTvShowsAdapter: FavoriteTvShowsAdapter

    private var _binding: FragmentFavoriteTvShowsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteTvShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteTvShowsAdapter = FavoriteTvShowsAdapter()

        val factory = ViewModelFactory.getInstance(requireContext())
        viewModel = ViewModelProvider(this, factory)[FavoriteTvShowsViewModel::class.java]

        getData()

        favoriteTvShowsAdapter.setOnItemClickCallback(object :
            FavoriteTvShowsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: TvShowsEntity) {
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra(Constant.EXTRA_ID, data.id)
                    putExtra(Constant.EXTRA_CODE, Constant.CODE_TV)
                }
                startActivity(intent)
            }
        })

        with(binding.rvFavoriteTvShows) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = favoriteTvShowsAdapter
        }
    }

    private fun getData() {
        viewModel.getFavoriteTvShows().observe(viewLifecycleOwner, { response ->
            if (response != null) {
                favoriteTvShowsAdapter.submitList(response)
                emptyList(false)

                if (response.isEmpty()) {
                    emptyList(true)
                }
            }
        })
    }

    private fun emptyList(isEmpty: Boolean) {
        if (isEmpty) {
            binding.imgEmpty.visibility = View.VISIBLE
            binding.tvEmpty.visibility = View.VISIBLE
        } else {
            binding.imgEmpty.visibility = View.GONE
            binding.tvEmpty.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}