package com.example.androidapp.ui

import Note
import com.example.androidapp.ui.util.NoteOrder
import com.example.androidapp.ui.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false

)
