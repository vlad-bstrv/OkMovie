package com.vladbstrv.okmovie.model.repository

import com.vladbstrv.okmovie.model.Movie
import com.vladbstrv.okmovie.model.getMovie

class RepositoryImpl : Repository {
    override fun getMovieFromServer() = Movie()

    override fun getMovieFromLocalStorage() = getMovie()
}