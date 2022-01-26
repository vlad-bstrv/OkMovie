package com.vladbstrv.okmovie.model.entities.rest_entities

import com.google.gson.annotations.SerializedName

data class Genres(
    @SerializedName("name") val name : String
)
