package com.vladbstrv.okmovie.model.entities.rest_entities

import com.google.gson.annotations.SerializedName

data class Countries(
    @SerializedName("name") val name : String
)
