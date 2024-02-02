package com.example.androidapp.ui.data_source.repository

import Note
import com.example.androidapp.ui.data_source.NoteDao
import com.example.androidapp.ui.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

// This implements the functions from NoteRepository
class NoteRepositoryImpl (
    private val dao: NoteDao
): NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}