package com.vladbstrv.okmovie.screens.detail

import android.app.Application
import androidx.lifecycle.*
import com.vladbstrv.okmovie.REPOSITORY
import com.vladbstrv.okmovie.model.AppState
import com.vladbstrv.okmovie.model.data.movie.MovieApi
import com.vladbstrv.okmovie.model.database.NoteDatabase
import com.vladbstrv.okmovie.model.database.model.NoteModel
import com.vladbstrv.okmovie.model.database.repository.NoteRepositoryImpl
import com.vladbstrv.okmovie.model.note.Note
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DetailViewModel(application: Application) : AndroidViewModel(application) {
    private val localLiveData: MutableLiveData<AppState> = MutableLiveData()
    val movieLiveData: LiveData<AppState>
        get() {
            return localLiveData
        }

    val context = application

    fun initDatabase(id: Int) {
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRepositoryImpl(daoNote, id)
    }

    fun getNotesToId(): LiveData<List<NoteModel>> {
        return REPOSITORY.notesByIdToServer
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }

    fun insert(noteModel: NoteModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertNote(noteModel) {
                onSuccess()
            }
        }

    fun delete(noteModel: NoteModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteNote(noteModel) {
                onSuccess()
            }
        }


    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun loadData(movieApi: MovieApi?, id: Int) {
        localLiveData.value = AppState.Loading
        movieApi?.let {
            compositeDisposable.add(
                movieApi.getMovie(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        localLiveData.postValue(AppState.SuccessMovie(it))
                    }, {

                    })
            )
        }
    }
}