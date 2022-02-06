package com.vladbstrv.okmovie.model.repository

import androidx.lifecycle.LiveData
import com.vladbstrv.okmovie.model.Movie
import com.vladbstrv.okmovie.model.note.Note

interface Repository {
    fun getMovieFromServer(id: Int): Movie
    fun getMovieFromLocalStorage(): List<Movie>
    fun getMovieTrendsFromServer(): List<Movie>
}