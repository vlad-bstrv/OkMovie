package com.vladbstrv.okmovie.screens.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladbstrv.okmovie.model.Genre
import com.vladbstrv.okmovie.model.Movie
import com.vladbstrv.okmovie.model.getGenre
import com.vladbstrv.okmovie.model.repository.Repository
import com.vladbstrv.okmovie.model.repository.RepositoryImpl
import com.vladbstrv.okmovie.screens.AppState
import java.lang.Thread.sleep

class FeedViewModel : ViewModel() {

    private val _trendsMovie = MutableLiveData<AppState>()
    val trendsMovie: LiveData<AppState> = _trendsMovie

    private val _genre = MutableLiveData<List<Genre>>()
    val genre: LiveData<List<Genre>> = _genre

    private val repository: Repository = RepositoryImpl()

    init {
        loadMovie()
        loadGenre()
    }

    fun getMovieFromLocalStorage() = loadMovie()

    private fun loadGenre() {
        _genre.value = getGenre()
    }

    private fun loadMovie() {
        _trendsMovie.value = AppState.Loading
        Thread {
//            sleep(2000)
            _trendsMovie.postValue(AppState.Success(repository.getMovieFromLocalStorage()))
        }.start()
    }
}