package com.vladbstrv.okmovie.model

import android.os.Parcelable
import com.vladbstrv.okmovie.model.entities.rest_entities.Genres
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Movie(
    val id: Int = 1,
    val poster: String = "",
    val title: String = "Название",
//    val genre: List<Genres> = listOf(),
    val description: String = "Описание"
) : Parcelable

fun getMovie() : List<Movie> {
    return listOf(
    Movie(336, "", "Зеленая миля"),
    Movie(337, "", "Побег из Шоушенка"),
    Movie(338, "", "Властелин колец: Возвращение короля"),
    Movie(339, "", "Властелин колец: Две крепости"),
    Movie(340, "", "Властелин колец: Братство Кольца"),
    Movie(336, "", "Форрест Гамп"),
    Movie(336, "", "Список Шиндлера"),
    Movie(336, "", "1+1"),
    Movie(336, "", "Король Лев"),
    Movie(336, "", "Интерстеллар")
    )
}

