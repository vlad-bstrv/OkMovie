package com.vladbstrv.okmovie.model.repository

import com.vladbstrv.okmovie.model.Movie
import com.vladbstrv.okmovie.model.getMovie

class RepositoryImpl : Repository {
    override fun getMovieFromServer(): Movie {
        return Movie()
    }

    override fun getMovieFromLocalStorage(): List<Movie> {
        return getMovie()
    }
}