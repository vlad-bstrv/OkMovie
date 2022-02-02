package com.vladbstrv.okmovie.model.data.movie

import com.vladbstrv.okmovie.model.data.entities.rest_entities.MovieDTO
import com.vladbstrv.okmovie.model.data.entities.rest_entities.MovieListDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("./movie?")
    fun getMovie(
        @Query("search") id: Int,
        @Query("field") field: String = "id",
        @Query("token") token: String = "0TTB526-VYFM09X-Q70RE5V-Y2B1YEC"
    ): Single<MovieDTO>

    @GET("movie?&sortField=votes.imdb&sortType=-1")
    fun getMovieList(
        @Query("field") fieldRating: String = "rating.kp",
        @Query("search") searchRating: String = "7-10",
        @Query("field") fieldYear: String = "year",
        @Query("search") searchYear: String = "2021-2022",
        @Query("field") fieldTypeNumber: String = "typeNumber",
        @Query("search") searchTypeNumber: String = "1",
        @Query("token") token: String = "0TTB526-VYFM09X-Q70RE5V-Y2B1YEC"
    ): Single<MovieListDTO>

}