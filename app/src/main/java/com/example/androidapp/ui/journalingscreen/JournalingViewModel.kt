package com.example.androidapp.ui.journalingscreen


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapp.ui.journalingscreen.data.MongoRepository
import com.example.androidapp.ui.journalingscreen.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.mongodb.kbson.ObjectId
import javax.inject.Inject

@HiltViewModel
class JournalingViewModel @Inject constructor(
    private val repository: MongoRepository
) : ViewModel() {
    var journal = mutableStateOf("")
    var title= mutableStateOf("")
    var objectId = mutableStateOf("")
    var filtered = mutableStateOf(false)
    var data = mutableStateOf(emptyList<Note>())

    init {
        viewModelScope.launch {
            repository.getData().collect {
                data.value = it
            }
        }
    }

    fun updateTitle(title: String) {
        this.title.value = title
    }

    fun updateJournal(journal: String) {
        this.journal.value = journal
    }

    fun updateObjectId(id: String) {
        this.objectId.value = id
    }

    fun insertNote() {
        viewModelScope.launch(Dispatchers.IO) {
            if (title.value.isNotEmpty()) {
                repository.insertNote(note = Note().apply {
                    title = this@JournalingViewModel.title.value
                    journal = this@JournalingViewModel.journal.value
                })
            }
        }
    }

    fun updateNote() {
        viewModelScope.launch(Dispatchers.IO) {
            if (objectId.value.isNotEmpty()) {
                repository.updateNote(note = Note().apply {
                    _id = ObjectId(hexString = this@JournalingViewModel.objectId.value)
                    title = this@JournalingViewModel.title.value
                    journal = this@JournalingViewModel.journal.value
                })
            }
        }
    }

    fun deleteNote() {
        viewModelScope.launch {
            if (objectId.value.isNotEmpty()) {
                repository.deleteNote(id = ObjectId(hexString = objectId.value))
            }
        }
    }

    fun filterData() {
        viewModelScope.launch(Dispatchers.IO) {
            if (filtered.value) {
                repository.getData().collect {
                    filtered.value = false
                    title.value = ""
                    journal.value = ""
                    data.value = it
                }
            } else {
                repository.filterData(title = title.value,
                    journal = journal.value)
                    .collect {
                        filtered.value = true
                        data.value = it
                    }
            }
        }
    }

}