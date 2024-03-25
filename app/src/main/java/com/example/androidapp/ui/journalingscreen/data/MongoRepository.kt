package com.example.androidapp.ui.journalingscreen.data

import com.example.androidapp.ui.journalingscreen.model.Note
import com.example.androidapp.ui.journalingscreen.model.NoteItem
import kotlinx.coroutines.flow.Flow
import org.mongodb.kbson.ObjectId

interface MongoRepository {
    fun getData(): Flow<List<Note>>
    fun filterData(title: String, journal: String): Flow<List<Note>>
    suspend fun insertNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(id: ObjectId)
}