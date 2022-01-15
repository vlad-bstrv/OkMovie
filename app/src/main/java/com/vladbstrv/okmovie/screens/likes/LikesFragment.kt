package com.vladbstrv.okmovie.screens.likes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vladbstrv.okmovie.databinding.FragmentLikesBinding

class LikesFragment : Fragment() {

    private var _binding: FragmentLikesBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLikesBinding.inflate(inflater, container, false)
        return mBinding.root
    }
}