package com.vladbstrv.okmovie.screens.feed

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladbstrv.okmovie.model.Genre
import com.vladbstrv.okmovie.model.data.entities.rest_entities.MovieListDTO
import com.vladbstrv.okmovie.model.data.movie.MovieApi
import com.vladbstrv.okmovie.model.getGenre
import com.vladbstrv.okmovie.model.repository.Repository
import com.vladbstrv.okmovie.model.repository.RepositoryImpl
import com.vladbstrv.okmovie.screens.AppState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FeedViewModel : ViewModel() {
    private val _genre = MutableLiveData<List<Genre>>()
    val genre: LiveData<List<Genre>> = _genre

    private val localLiveDataMovie: MutableLiveData<MovieListDTO> = MutableLiveData()
    val movieLiveDataMovie: LiveData<MovieListDTO> = localLiveDataMovie

    private val localLiveDataMovieNews: MutableLiveData<MovieListDTO> = MutableLiveData()
    val movieLiveDataMovieNews: LiveData<MovieListDTO> = localLiveDataMovieNews

    private val localLiveDataMovieSerials: MutableLiveData<MovieListDTO> = MutableLiveData()
    val movieLiveDataMovieSerials: LiveData<MovieListDTO> = localLiveDataMovieSerials

    private val localLiveDataMovieCartoon: MutableLiveData<MovieListDTO> = MutableLiveData()
    val movieLiveDataMovieCartoon: LiveData<MovieListDTO> = localLiveDataMovieCartoon

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    init {
        loadGenre()
    }

    private fun loadGenre() {
        _genre.value = getGenre()
    }

    fun fetchMovieList(movieApi: MovieApi?) {
        movieApi?.let {
            compositeDisposable.add(
                movieApi.getMovieList()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        localLiveDataMovie.postValue(it)
                    }, {

                    })
            )
        }
    }

    fun fetchMovieListNews(movieApi: MovieApi?) {
        movieApi?.let {
            compositeDisposable.add(
                movieApi.getMovieList(
                    searchRating = "2-10",
                    searchYear = "2022"
                )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        localLiveDataMovieNews.postValue(it)
                    }, {

                    })
            )
        }
    }

    fun fetchMovieListSerials(movieApi: MovieApi?) {
        movieApi?.let {
            compositeDisposable.add(
                movieApi.getMovieList(searchTypeNumber = "2")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        localLiveDataMovieSerials.postValue(it)
                    }, {

                    })
            )
        }
    }

    fun fetchMovieListCartoon(movieApi: MovieApi?) {
        movieApi?.let {
            compositeDisposable.add(
                movieApi.getMovieList(searchTypeNumber = "3")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        localLiveDataMovieCartoon.postValue(it)
                    }, {

                    })
            )
        }
    }
}