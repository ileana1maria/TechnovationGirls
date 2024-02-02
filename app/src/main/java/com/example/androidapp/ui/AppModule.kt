package com.example.androidapp.ui

import android.app.Application
import androidx.room.Room
import com.example.androidapp.ui.data_source.NoteDatabase
import com.example.androidapp.ui.data_source.repository.NoteRepositoryImpl
import com.example.androidapp.ui.repository.NoteRepository
import com.example.androidapp.ui.use_cases.AddNote
import com.example.androidapp.ui.use_cases.DeleteNote
import com.example.androidapp.ui.use_cases.GetNotes
import com.example.androidapp.ui.use_cases.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases (repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)

        )
    }
}