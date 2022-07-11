package com.dev.divig.findmovies.ui.favorite.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dev.divig.findmovies.data.source.local.entity.MovieEntity
import com.dev.divig.findmovies.databinding.FragmentFavoriteMovieBinding
import com.dev.divig.findmovies.ui.detail.DetailActivity
import com.dev.divig.findmovies.utils.Constant
import com.dev.divig.findmovies.viewmodel.ViewModelFactory

class FavoriteMovieFragment : Fragment() {
    private lateinit var viewModel: FavoriteMovieViewModel
    private lateinit var favoriteMovieAdapter: FavoriteMovieAdapter

    private var _binding: FragmentFavoriteMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteMovieAdapter = FavoriteMovieAdapter()

        val factory = ViewModelFactory.getInstance(requireContext())
        viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]

        getData()

        favoriteMovieAdapter.setOnItemClickCallback(object :
            FavoriteMovieAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MovieEntity) {
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra(Constant.EXTRA_ID, data.id)
                    putExtra(Constant.EXTRA_CODE, Constant.CODE_MOVIE)
                }
                startActivity(intent)
            }
        })

        with(binding.rvFavoriteMovie) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = favoriteMovieAdapter
        }
    }

    private fun getData() {
        viewModel.getFavoriteMovie().observe(viewLifecycleOwner, { response ->
            if (response != null) {
                favoriteMovieAdapter.submitList(response)
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