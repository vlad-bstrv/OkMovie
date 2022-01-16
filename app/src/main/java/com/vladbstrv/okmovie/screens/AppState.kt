package com.vladbstrv.okmovie.screens

import com.vladbstrv.okmovie.model.Movie

sealed class AppState {
    data class Success(val movieData: List<Movie>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
