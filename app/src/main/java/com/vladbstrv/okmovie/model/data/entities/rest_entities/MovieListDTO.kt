package com.vladbstrv.okmovie.model.data.entities.rest_entities

import com.google.gson.annotations.SerializedName

data class MovieListDTO(
    @SerializedName("docs") val docs: List<Docs>
)

data class Docs(

    @SerializedName("poster") val poster : Poster,
    @SerializedName("rating") val rating : Rating,
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("year") val year : Int,
    @SerializedName("shortDescription") val shortDescription : String,
)

