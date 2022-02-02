package com.vladbstrv.okmovie.model.data.entities.rest_entities

import com.google.gson.annotations.SerializedName

data class SimilarMovies(
    @SerializedName("_id") val _id : String,
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("enName") val enName : String,
    @SerializedName("alternativeName") val alternativeName : String,
    @SerializedName("poster") val poster : Poster
)
