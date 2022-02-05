package com.vladbstrv.okmovie.model.database.repository

import androidx.lifecycle.LiveData
import com.vladbstrv.okmovie.model.database.dao.NoteDao
import com.vladbstrv.okmovie.model.database.model.NoteModel

class NoteRepositoryImpl(private val noteDao: NoteDao, id: Int): NoteRepository {

    val id = id

    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override val notesByIdToServer: LiveData<List<NoteModel>>
        get() = noteDao.getNotesToId(id)

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }
}