package com.vladbstrv.okmovie.screens.detail

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladbstrv.okmovie.model.data.entities.rest_entities.MovieDTO
import com.vladbstrv.okmovie.model.data.movie.MovieApi
import com.vladbstrv.okmovie.model.repository.Repository
import com.vladbstrv.okmovie.screens.AppState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class DetailViewModel : ViewModel() {
    private val localLiveData: MutableLiveData<MovieDTO> = MutableLiveData()
    val movieLiveData: LiveData<MovieDTO>
        get() {
            return localLiveData
        }

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun loadData(movieApi: MovieApi?, id: Int) {
        movieApi?.let {
            compositeDisposable.add(movieApi.getMovie(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    localLiveData.postValue(it)
                }, {

                })
            )
        }
    }
}