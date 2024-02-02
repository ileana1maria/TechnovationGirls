package com.example.androidapp.ui.repository

import Note
import kotlinx.coroutines.flow.Flow

//Here we define the functions that you can use to access the database

interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById (id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)


}