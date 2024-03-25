package com.example.androidapp.ui.journalingscreen.model

import androidx.compose.runtime.mutableStateOf
import com.example.androidapp.ui.theme.Pink80
import com.example.androidapp.ui.theme.Purple40
import com.example.androidapp.ui.theme.Purple80
import com.example.androidapp.ui.theme.PurpleGrey80
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.Ignore
import io.realm.kotlin.types.annotations.Index
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class Note : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId.invoke()
    var title: String = ""
    var journal: String = ""

    // to-many
    var notesitem: RealmList<NoteItem> = realmListOf()
    @Ignore
    var noteColors = listOf(
        Purple80, PurpleGrey80,
        Pink80, Purple40
    )
    var timestamp: RealmInstant = RealmInstant.now()
}

class NoteItem: RealmObject {
    var content: String = ""
}