package com.vladbstrv.okmovie.screens.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladbstrv.okmovie.model.Movie

class FeedViewModel : ViewModel() {

    private val _trendsMovie = MutableLiveData<List<Movie>>()
    val trendsMovie: LiveData<List<Movie>> = _trendsMovie

    private val _genre = MutableLiveData<List<String>>()
    val genre: LiveData<List<String>> = _genre

    init {
        loadMovie()
        loadGenre()
    }

    private fun loadGenre() {
        val list = mutableListOf<String>()
        list.add("Семейные")
        list.add("Комедии")
        list.add("Фэнтези")
        list.add("Триллеры")
        list.add("Драммы")
        list.add("Приключения")
        list.add("Документальные")
        list.add("Ужасы")
        list.add("Фантастика")
        list.add("Аниме")
        list.add("Короткометражки")
        list.add("Боевики")
        list.add("Мелодрамы")
        list.add("Биографии")
        list.add("Детективы")
        list.add("Авторское кино")
        list.add("Криминальные")
        list.add("Мультфильмы")
        list.add("Истоические")
        _genre.value = list
    }

    private fun loadMovie() {
        val list = mutableListOf<Movie>()
        list.add(Movie(1, "", "название", "жанр"))
        list.add(Movie(2, "", "название", "жанр"))
        list.add(Movie(3, "", "название", "жанр"))
        list.add(Movie(4, "", "название", "жанр"))
        list.add(Movie(5, "", "название", "жанр"))
        list.add(Movie(6, "", "название", "жанр"))
        list.add(Movie(7, "", "название", "жанр"))
        list.add(Movie(8, "", "название", "жанр"))
        list.add(Movie(9, "", "название", "жанр"))
        list.add(Movie(10, "", "название", "жанр"))

        _trendsMovie.value = list
    }
}