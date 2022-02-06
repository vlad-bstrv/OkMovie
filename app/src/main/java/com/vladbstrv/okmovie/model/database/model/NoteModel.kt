package com.vladbstrv.okmovie.model.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "note_table")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String = "",
    var idToServer: Int = 336
) : Serializable