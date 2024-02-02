package com.example.androidapp.ui.use_cases

import InvalidNoteException
import Note
import com.example.androidapp.ui.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote (
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        repository.insertNote(note)
    }
}