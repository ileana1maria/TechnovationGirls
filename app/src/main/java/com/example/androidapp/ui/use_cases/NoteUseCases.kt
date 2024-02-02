package com.example.androidapp.ui.use_cases


// Has all the tasks that the user can make with the database
data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote,

)
