package com.vladbstrv.okmovie.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vladbstrv.okmovie.R
import com.vladbstrv.okmovie.databinding.FragmentDetailBinding
import com.vladbstrv.okmovie.model.Movie

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val mBinding get() = _binding!!

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
        val movie = arguments?.getParcelable<Movie>(movieKey)
        mBinding.title.text = movie?.title
        mBinding.genre.text = movie?.genre
    }

    companion object {
        const val movieKey = "movieKey"
    }
}