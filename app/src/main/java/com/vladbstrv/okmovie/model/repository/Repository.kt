package com.vladbstrv.okmovie.model.repository

import com.vladbstrv.okmovie.model.Movie

interface Repository {

    fun getMovieFromServer(): Movie
    fun getMovieFromLocalStorage(): List<Movie>
}