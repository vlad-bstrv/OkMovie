package com.vladbstrv.okmovie.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vladbstrv.okmovie.OkMovieApp
import com.vladbstrv.okmovie.R

import com.vladbstrv.okmovie.databinding.FragmentDetailBinding
import com.vladbstrv.okmovie.model.AppState

import com.vladbstrv.okmovie.model.data.entities.rest_entities.MovieDTO
import com.vladbstrv.okmovie.model.database.model.NoteModel
import com.vladbstrv.okmovie.model.note.Note
import org.koin.android.ext.android.inject

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val mBinding get() = _binding!!
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var mAdapterActors: DetailActorsAdapter
    private lateinit var mAdapterNote: NoteAdapter
    private lateinit var recyclerViewNote: RecyclerView

    interface OnItemViewClickListener {
        fun OnItemViewClick(noteModel: NoteModel)
    }

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

        mAdapterActors = DetailActorsAdapter()
        mBinding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = mAdapterActors
        }

        viewModel.movieLiveData.observe(viewLifecycleOwner, Observer {
            renderData(it)
        })

        movieId?.let { initNote(it) }
    }

    private fun initNote(movieId: Int) {
        viewModel.initDatabase()
        recyclerViewNote = mBinding.recyclerViewNote
        mAdapterNote = NoteAdapter(object : OnItemViewClickListener {
            override fun OnItemViewClick(noteModel: NoteModel) {
                viewModel.delete(noteModel){}
            }
        })
        recyclerViewNote.adapter = mAdapterNote
        viewModel.getAllNotes().observe(viewLifecycleOwner){listNotes ->
            mAdapterNote.setData(listNotes.asReversed())
        }
        mBinding.btnAddNote.setOnClickListener {
            val noteText = mBinding.textInputNote.text.toString()
            viewModel.insert(NoteModel(title = noteText, idToServer = movieId)){}
        }
    }

    private fun renderData(appState: AppState) = with(mBinding) {
        when (appState) {
            is AppState.SuccessMovie -> {
                loadingLayout.visibility = View.GONE

                mBinding.title.text = appState.movieData.name
                mBinding.description.text = appState.movieData.description
                loadGenre(appState.movieData)
                mAdapterActors.setData(appState.movieData.persons)
                Glide.with(requireActivity()).load(appState.movieData.poster.url)
                    .into(mBinding.poster)
            }
            is AppState.Loading -> {
                loadingLayout.visibility = View.VISIBLE
            }

            else -> {}
        }
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