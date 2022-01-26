package com.vladbstrv.okmovie.model.entities.rest_entities

import com.google.gson.annotations.SerializedName

data class MovieDTO(
    @SerializedName("poster") val poster : Poster,
    @SerializedName("rating") val rating : Rating,
    @SerializedName("premiere") val premiere : Premiere,
    @SerializedName("movieLength") val movieLength : Int,
    @SerializedName("id") val id : Int,
    @SerializedName("type") val type : String,
    @SerializedName("name") val name : String,
    @SerializedName("description") val description : String,
    @SerializedName("slogan") val slogan : String,
    @SerializedName("year") val year : Int,
    @SerializedName("genres") val genres : List<Genres>,
    @SerializedName("countries") val countries : List<Countries>,
    @SerializedName("persons") val persons : List<Persons>,
    @SerializedName("similarMovies") val similarMovies : List<SimilarMovies>
)
