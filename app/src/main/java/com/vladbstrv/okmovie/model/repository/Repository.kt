package com.vladbstrv.okmovie.model.repository

import com.vladbstrv.okmovie.model.Movie

interface Repository {

    fun getMovieFromServer(id: Int): Movie
    fun getMovieFromLocalStorage(): List<Movie>
    fun getMovieTrendsFromServer(): List<Movie>
}