package com.vladbstrv.okmovie.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int = 1,
    val poster: String = "",
    val title: String = "Название",
//    val genre: List<Genres> = listOf(),
    val description: String = "Описание"
) : Parcelable


