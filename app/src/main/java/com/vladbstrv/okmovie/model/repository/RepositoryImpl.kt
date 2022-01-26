package com.vladbstrv.okmovie.model.repository

import com.vladbstrv.okmovie.model.Movie
import com.vladbstrv.okmovie.model.MovieLoader
import com.vladbstrv.okmovie.model.MovieTrendsLoader
import com.vladbstrv.okmovie.model.entities.rest_entities.Genres
import com.vladbstrv.okmovie.model.getMovie

class RepositoryImpl : Repository {
    override fun getMovieFromServer(id: Int): Movie {
        val dto = MovieLoader.loadMovie(id)
        return Movie(
            id = dto?.id ?: 1,
            poster = "",
            title = dto?.name ?: "name",
//            genre = dto?.genres ?: listOf<Genres>(),
            description = dto?.description ?: "Описание"
        )
    }


    override fun getMovieFromLocalStorage(): List<Movie> {
        return getMovie()
    }

    override fun getMovieTrendsFromServer(): List<Movie> {
        val dtoList = MovieTrendsLoader.loadMovie()?.docs
        val listMovie = mutableListOf<Movie>()
        dtoList?.forEach {
            listMovie.add(
                Movie(
                    id = it.id,
                    title = it.name,
                    description = it.shortDescription ?: "без описания"
                )
            )
        }
        return listMovie
    }
}