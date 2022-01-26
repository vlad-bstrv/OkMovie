package com.vladbstrv.okmovie.model.entities.rest_entities

import com.google.gson.annotations.SerializedName

data class Poster(
    @SerializedName("_id") val _id : String,
    @SerializedName("url") val url : String,
    @SerializedName("previewUrl") val previewUrl : String
)
