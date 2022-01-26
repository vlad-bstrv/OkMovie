package com.vladbstrv.okmovie.model.entities.rest_entities

import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("_id") val _id : String,
    @SerializedName("kp") val kp : Double,
    @SerializedName("imdb") val imdb : Double,
    @SerializedName("filmCritics") val filmCritics : Double,
    @SerializedName("russianFilmCritics") val russianFilmCritics : Int,
    @SerializedName("await") val await : Int
)
