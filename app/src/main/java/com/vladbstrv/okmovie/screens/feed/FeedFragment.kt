package com.vladbstrv.okmovie.screens.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.vladbstrv.okmovie.R
import com.vladbstrv.okmovie.databinding.FragmentFeedBinding
import com.vladbstrv.okmovie.model.Movie
import com.vladbstrv.okmovie.screens.AppState
import com.vladbstrv.okmovie.screens.detail.DetailFragment
import com.vladbstrv.okmovie.screens.feed.adapters.FeedAdapter
import com.vladbstrv.okmovie.screens.feed.adapters.GenresAdapter

class FeedFragment : Fragment() {

    interface OnItemViewClickListener {
        fun OnItemViewClick(movie: Movie)
    }

    private var _binding: FragmentFeedBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var adapter: FeedAdapter
    private lateinit var adapterGenres: GenresAdapter

//    private val mAdapter = FeedAdapter()
//    private val mAdapterGenres = GenresAdapter()

    private val viewModel: FeedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FeedAdapter(object : OnItemViewClickListener {
            override fun OnItemViewClick(movie: Movie) {
                findNavController().navigate(
                    R.id.action_feedFragment2_to_detailFragment,
                    bundleOf(DetailFragment.movieKey to movie)
                )
            }

        })
        adapterGenres = GenresAdapter()

        viewModel.trendsMovie.observe(viewLifecycleOwner, Observer {
            renderData(it)
        })
        viewModel.genre.observe(viewLifecycleOwner, Observer {
            adapterGenres.setData(it)
        })

        mBinding.recyclerViewTrend.adapter = adapter
        mBinding.recyclerViewNewProducts.adapter = adapter
        mBinding.recyclerViewTopSerials.adapter = adapter
        mBinding.recyclerViewGenres.adapter = adapterGenres

    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                mBinding.loadingLayout.visibility = View.GONE
                adapter.setData(appState.movieData)
                }
            is AppState.Loading -> {
                mBinding.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                mBinding.loadingLayout.visibility = View.GONE
                Snackbar.make(mBinding.feedFragmentFrameLayout, getString(R.string.error),
                Snackbar.LENGTH_INDEFINITE).setAction(getString(R.string.reload)){
                    viewModel.getMovieFromLocalStorage()
                }.show()
            }
        }
    }

}