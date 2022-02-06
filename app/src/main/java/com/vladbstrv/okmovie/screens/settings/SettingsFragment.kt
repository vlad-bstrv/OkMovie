package com.vladbstrv.okmovie.screens.settings

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.vladbstrv.okmovie.databinding.FragmentSettingsBinding

const val DATA_SET_KEY = "datasetKey"

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val mBinding get() = _binding!!

    private var isDataAdultSet: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(mBinding) {
        super.onViewCreated(view, savedInstanceState)
        loadDataSet()
        switchAdult.isChecked = isDataAdultSet
        switchAdult.setOnClickListener { changeAdultContent() }
    }

    private fun changeAdultContent() {
        isDataAdultSet = !isDataAdultSet
        saveDataSetToDisk()
    }

    private fun loadDataSet() {
        activity?.let {
            isDataAdultSet = activity
                ?.getPreferences(Context.MODE_PRIVATE)
                ?.getBoolean(DATA_SET_KEY, true) ?: true
        }
    }

    private fun saveDataSetToDisk() {
        val editor = activity?.getPreferences(Context.MODE_PRIVATE)?.edit()
        editor?.putBoolean(DATA_SET_KEY, isDataAdultSet)
        editor?.apply()
    }
}