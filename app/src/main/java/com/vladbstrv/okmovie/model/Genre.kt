package com.vladbstrv.okmovie.model

data class Genre(
    val name: String
)

fun getGenre() : List<Genre> {
    return listOf(
        Genre("Семейные"),
        Genre("Комедии"),
        Genre("Фэнтези"),
        Genre("Триллеры"),
        Genre("Драммы"),
        Genre("Приключения"),
        Genre("Документальные"),
        Genre("Ужасы"),
        Genre("Фантастика"),
        Genre("Аниме"),
        Genre("Короткометражки"),
        Genre("Боевики"),
        Genre("Мелодрамы"),
        Genre("Биографии"),
        Genre("Детективы"),
        Genre("Авторское кино"),
        Genre("Криминальные"),
        Genre("Мультфильмы"),
        Genre("Истоические")
    )
}
