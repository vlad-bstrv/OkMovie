package com.vladbstrv.okmovie.model

import com.vladbstrv.okmovie.model.data.entities.rest_entities.MovieDTO
import com.vladbstrv.okmovie.model.data.entities.rest_entities.MovieListDTO
import com.vladbstrv.okmovie.model.note.Note

sealed class AppState {
    data class SuccessList(val movieData: MovieListDTO) : AppState()
    data class SuccessMovie(val movieData: MovieDTO) : AppState()
    data class SuccessNote(val note: List<Note>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
