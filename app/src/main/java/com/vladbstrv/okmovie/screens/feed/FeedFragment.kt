package com.vladbstrv.okmovie.screens.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.vladbstrv.okmovie.R
import com.vladbstrv.okmovie.databinding.FragmentFeedBinding
import com.vladbstrv.okmovie.screens.feed.adapters.FeedAdapter
import com.vladbstrv.okmovie.screens.feed.adapters.GenresAdapter

class FeedFragment : Fragment() {

    private var _binding: FragmentFeedBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var adapter: FeedAdapter
    private lateinit var adapterGenres: GenresAdapter

    private val mAdapter = FeedAdapter()
    private val mAdapterGenres = GenresAdapter()

    private val viewModel: FeedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeedBinding.inflate(inflater, container, false)

        adapter = FeedAdapter()
        adapterGenres = GenresAdapter()

        viewModel.trendsMovie.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
        viewModel.genre.observe(viewLifecycleOwner, Observer {
            adapterGenres.setData(it)
        })

        mBinding.recyclerViewTrend.adapter = adapter
        mBinding.recyclerViewNewProducts.adapter = adapter
        mBinding.recyclerViewTopSerials.adapter = adapter
        mBinding.recyclerViewGenres.adapter = adapterGenres

        return mBinding.root
    }

}