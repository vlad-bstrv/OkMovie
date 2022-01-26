package com.vladbstrv.okmovie.screens.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladbstrv.okmovie.model.repository.Repository
import com.vladbstrv.okmovie.screens.AppState


class DetailViewModel(private val repository: Repository) : ViewModel() {
    private val localLiveData: MutableLiveData<AppState> = MutableLiveData()
    val movieLiveData: LiveData<AppState>
        get() {
            return localLiveData
        }

    fun loadData(id: Int) {
        localLiveData.value = AppState.Loading
        Thread {
            val data = repository.getMovieFromServer(id)
            localLiveData.postValue(AppState.Success(listOf(data)))
        }.start()
    }
}