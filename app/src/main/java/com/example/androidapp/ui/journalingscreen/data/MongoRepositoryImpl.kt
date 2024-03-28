package com.example.androidapp.ui.journalingscreen.data

import android.util.Log
import com.example.androidapp.ui.journalingscreen.model.Note
import com.example.androidapp.ui.journalingscreen.model.NoteItem
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.mongodb.kbson.ObjectId

class MongoRepositoryImpl {
    class MongoRepositoryImpl(val realm: Realm) : MongoRepository {

        // This returns all the people
        override fun getData(): Flow<List<Note>> {
            return realm.query<Note>().asFlow().map { it.list }
        }

        // This returns the people that have the name name
        override fun filterData(title: String, journal: String): Flow<List<Note>> {
            return realm.query<Note>(query = "title CONTAINS $0", title).asFlow().map { it.list }
        }

        override suspend fun insertNote(note: Note) {
            realm.write { copyToRealm(note) }
        }

        override suspend fun updateNote(note: Note) {
            realm.write {
                val queriedNote = query<Note>(query = "_id == $0", note._id)
                    .first().find()
                queriedNote?.journal = note.journal
                queriedNote?.title = note.title

            }
        }

        override suspend fun deleteNote(id: ObjectId) {
            realm.write {
                val note = query<Note>(query = "_id == $0", id).first().find()
                try {
                    note?.let { delete(it) }
                } catch (e: Exception) {
                    Log.d("MongoRepositoryImpl", "${e.message}")
                }
            }
        }
    }
}