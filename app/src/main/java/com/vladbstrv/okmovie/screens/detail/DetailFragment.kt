package com.vladbstrv.okmovie.screens.detail

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.vladbstrv.okmovie.OkMovieApp
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.vladbstrv.okmovie.screens.AppState

import com.vladbstrv.okmovie.databinding.FragmentDetailBinding

import com.vladbstrv.okmovie.model.Movie
import com.vladbstrv.okmovie.model.data.entities.rest_entities.MovieDTO
import kotlinx.android.synthetic.main.fragment_detail.*
import java.lang.StringBuilder

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val mBinding get() = _binding!!
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var mAdapter: DetailActorsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieId = arguments?.getInt(movieKey)

        if (movieId != null) {
            viewModel.loadData(
                (activity?.application as? OkMovieApp)?.movieApi,
                movieId
            )
        }

        mAdapter = DetailActorsAdapter()
        mBinding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = mAdapter
        }

        viewModel.movieLiveData.observe(viewLifecycleOwner, Observer {
            mBinding.title.text = it.name
            mBinding.description.text = it.description
            loadGenre(it)
            mAdapter.setData(it.persons)
            Glide.with(this).load(it.poster.url).into(mBinding.poster)
        })
    }

    private fun loadGenre(movie: MovieDTO) {
        val genre = buildString {
            for (genre in movie.genres) {
                append(genre.name)
                append(", ")
            }
        }
        mBinding.genre.text = genre.dropLast(2)
        mBinding.years.text = movie.year.toString()
    }

    companion object {
        const val movieKey = "movieKey"
    }
}