package com.vladbstrv.okmovie.screens.feed

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.vladbstrv.okmovie.OkMovieApp
import com.vladbstrv.okmovie.R
import com.vladbstrv.okmovie.databinding.FragmentFeedBinding
import com.vladbstrv.okmovie.model.data.entities.rest_entities.Docs
import com.vladbstrv.okmovie.screens.detail.DetailFragment
import com.vladbstrv.okmovie.screens.feed.adapters.FeedAdapter
import com.vladbstrv.okmovie.screens.feed.adapters.GenresAdapter
import com.vladbstrv.okmovie.screens.settings.DATA_SET_KEY
import kotlinx.android.synthetic.main.fragment_feed.*


class FeedFragment : Fragment() {

    interface OnItemViewClickListener {
        fun OnItemViewClick(movie: Docs)
    }

    private var _binding: FragmentFeedBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var adapter: FeedAdapter
    private lateinit var adapterNews: FeedAdapter
    private lateinit var adapterSerials: FeedAdapter
    private lateinit var adapterCartoon: FeedAdapter
    private lateinit var adapterGenres: GenresAdapter
    private var isDataAdultSet: Boolean = true


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

        loadDataSet()

        adapter = FeedAdapter(object : OnItemViewClickListener {
            override fun OnItemViewClick(movie: Docs) {
                findNavController().navigate(
                    R.id.action_feedFragment2_to_detailFragment,
                    bundleOf(DetailFragment.movieKey to movie.id)
                )
            }
        })
        adapterNews = FeedAdapter(object : OnItemViewClickListener {
            override fun OnItemViewClick(movie: Docs) {
                findNavController().navigate(
                    R.id.action_feedFragment2_to_detailFragment,
                    bundleOf(DetailFragment.movieKey to movie.id)
                )
            }
        })
        adapterSerials = FeedAdapter(object : OnItemViewClickListener {
            override fun OnItemViewClick(movie: Docs) {
                findNavController().navigate(
                    R.id.action_feedFragment2_to_detailFragment,
                    bundleOf(DetailFragment.movieKey to movie.id)
                )
            }
        })

        if(isDataAdultSet) {
            tvCartoons.visibility = View.VISIBLE
            adapterCartoon = FeedAdapter(object : OnItemViewClickListener {
                override fun OnItemViewClick(movie: Docs) {
                    findNavController().navigate(
                        R.id.action_feedFragment2_to_detailFragment,
                        bundleOf(DetailFragment.movieKey to movie.id)
                    )
                }
            })

            viewModel.fetchMovieListCartoon((activity?.application as? OkMovieApp)?.movieApi)
            viewModel.movieLiveDataMovieCartoon.observe(viewLifecycleOwner, Observer {
                adapterCartoon.setData(it.docs)
            })

            mBinding.recyclerViewCartoon.adapter = adapterCartoon

        }

        adapterGenres = GenresAdapter()

        viewModel.genre.observe(viewLifecycleOwner, Observer {
            adapterGenres.setData(it)
        })

        viewModel.fetchMovieList((activity?.application as? OkMovieApp)?.movieApi)
        viewModel.movieLiveDataMovie.observe(viewLifecycleOwner, Observer {
            adapter.setData(it.docs)
        })

        viewModel.fetchMovieListNews((activity?.application as? OkMovieApp)?.movieApi)
        viewModel.movieLiveDataMovieNews.observe(viewLifecycleOwner, Observer {
            adapterNews.setData(it.docs)
        })

        viewModel.fetchMovieListSerials((activity?.application as? OkMovieApp)?.movieApi)
        viewModel.movieLiveDataMovieSerials.observe(viewLifecycleOwner, Observer {
            adapterSerials.setData(it.docs)
        })

        mBinding.recyclerViewTrend.adapter = adapter
        mBinding.recyclerViewNewProducts.adapter = adapterNews
        mBinding.recyclerViewTopSerials.adapter = adapterSerials
        mBinding.recyclerViewGenres.adapter = adapterGenres

    }

    private fun loadDataSet() {
        activity?.let {
            isDataAdultSet = activity
                ?.getPreferences(Context.MODE_PRIVATE)
                ?.getBoolean(DATA_SET_KEY, true) ?: true
        }
    }
}