package com.dev.divig.findmovies.ui.tvshows

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.dev.divig.findmovies.R
import com.dev.divig.findmovies.data.source.local.entity.TvShowsEntity
import com.dev.divig.findmovies.databinding.FragmentTvShowsBinding
import com.dev.divig.findmovies.ui.detail.DetailActivity
import com.dev.divig.findmovies.utils.Constant
import com.dev.divig.findmovies.utils.Utils
import com.dev.divig.findmovies.viewmodel.ViewModelFactory
import com.dev.divig.findmovies.vo.Resource
import com.dev.divig.findmovies.vo.Status

class TvShowsFragment : Fragment(), Toolbar.OnMenuItemClickListener {
    private lateinit var tvShowsAdapter: TvShowsAdapter
    private lateinit var tvShowsViewModel: TvShowsViewModel

    private var _binding: FragmentTvShowsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        binding.toolbarTvShows.setOnMenuItemClickListener(this)

        tvShowsAdapter = TvShowsAdapter()

        val factory = ViewModelFactory.getInstance(requireContext())
        tvShowsViewModel = ViewModelProvider(this, factory)[TvShowsViewModel::class.java]
        tvShowsViewModel.getTvShows(Constant.VOTE_RANDOM)
            .observe(viewLifecycleOwner, tvShowsObserver)

        tvShowsAdapter.setOnItemClickCallback(object : TvShowsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: TvShowsEntity) {
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra(Constant.EXTRA_ID, data.id)
                    putExtra(Constant.EXTRA_CODE, Constant.CODE_TV)
                }
                startActivity(intent)
            }
        })

        with(binding.rvTvShows) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = tvShowsAdapter
        }
    }

    private val tvShowsObserver = Observer<Resource<PagedList<TvShowsEntity>>> { response ->
        if (response != null) {
            when (response.status) {
                Status.LOADING -> onProgress(true)
                Status.SUCCESS -> {
                    onProgress(false)
                    tvShowsAdapter.submitList(response.data)
                    tvShowsAdapter.notifyDataSetChanged()
                }
                Status.ERROR -> {
                    onProgress(false)
                    Utils.showToast(requireContext(), getString(R.string.message_failure))
                }
            }
        }
    }

    private fun onProgress(isProgress: Boolean) {
        if (isProgress) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        var sort = ""
        when (item?.itemId) {
            R.id.vote_random -> sort = Constant.VOTE_RANDOM
            R.id.vote_best -> sort = Constant.VOTE_BEST
            R.id.vote_worst -> sort = Constant.VOTE_WORST
        }
        item?.isChecked = true
        tvShowsViewModel.getTvShows(sort).observe(viewLifecycleOwner, tvShowsObserver)

        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}