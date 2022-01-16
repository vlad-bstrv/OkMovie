package com.vladbstrv.okmovie.model

data class Genre(
    val id: Long,
    val name: String
)

fun getGenre() : List<Genre> {
    return listOf(
        Genre(1,"Семейные"),
        Genre(2,"Комедии"),
        Genre(3,"Фэнтези"),
        Genre(4,"Триллеры"),
        Genre(5,"Драммы"),
        Genre(6,"Приключения"),
        Genre(7,"Документальные"),
        Genre(8,"Ужасы"),
        Genre(9,"Фантастика"),
        Genre(10,"Аниме"),
        Genre(11,"Короткометражки"),
        Genre(12,"Боевики"),
        Genre(13,"Мелодрамы"),
        Genre(14,"Биографии"),
        Genre(14,"Детективы"),
        Genre(14,"Авторское кино"),
        Genre(14,"Криминальные"),
        Genre(14,"Мультфильмы"),
        Genre(14,"Истоические")
    )
}
