package com.example.androidapp.ui.use_cases

import Note
import com.example.androidapp.ui.repository.NoteRepository


// a single thing that the app does/ a user does
class DeleteNote (
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}