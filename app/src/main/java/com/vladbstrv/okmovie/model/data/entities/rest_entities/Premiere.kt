package com.vladbstrv.okmovie.model.data.entities.rest_entities

import com.google.gson.annotations.SerializedName

data class Premiere(
    @SerializedName("_id") val _id : String,
    @SerializedName("country") val country : String,
    @SerializedName("world") val world : String,
    @SerializedName("russia") val russia : String,
    @SerializedName("cinema") val cinema : String,
    @SerializedName("dvd") val dvd : String,
    @SerializedName("bluray") val bluray : String
)
