package com.example.androidapp.ui.data_source

import Note
import androidx.room.Database
import androidx.room.RoomDatabase


//This creates a class for our database
@Database (
    entities = [Note:: class],
    version = 1
)

abstract class NoteDatabase: RoomDatabase(){

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}