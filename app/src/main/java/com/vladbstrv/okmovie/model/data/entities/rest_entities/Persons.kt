package com.vladbstrv.okmovie.model.data.entities.rest_entities

import com.google.gson.annotations.SerializedName

data class Persons(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("enName") val enName: String,
    @SerializedName("description") val description: String,
    @SerializedName("enProfession") val enProfession: String,
    @SerializedName("photo") val photo: String
)
