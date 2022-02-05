package com.vladbstrv.okmovie.model.database.repository

import androidx.lifecycle.LiveData
import com.vladbstrv.okmovie.model.database.model.NoteModel

interface NoteRepository {
    val allNotes: LiveData<List<NoteModel>>
    suspend fun insertNote(noteModel: NoteModel, onSuccess:() -> Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess:() -> Unit)
}