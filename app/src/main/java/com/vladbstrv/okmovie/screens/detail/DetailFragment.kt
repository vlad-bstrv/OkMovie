package com.vladbstrv.okmovie.screens.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.vladbstrv.okmovie.screens.AppState

import com.vladbstrv.okmovie.databinding.FragmentDetailBinding
import com.vladbstrv.okmovie.model.Movie
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val mBinding get() = _binding!!
    private val viewModel: DetailViewModel by viewModel()

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
            viewModel.loadData(movieId)
        }


        viewModel.movieLiveData.observe(viewLifecycleOwner, {
            when (it) {
                is AppState.Success -> {
                    mBinding.title.text = it.movieData[0].title
                    mBinding.description.text = it.movieData[0].description
                }
            }
        })
    }

    companion object {
        const val movieKey = "movieKey"
    }
}