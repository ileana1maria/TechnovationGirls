package com.example.myapplication.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androidapp.ui.journalingscreen.JournalingViewModel
import com.example.androidapp.ui.journalingscreen.model.Note
import io.realm.kotlin.types.RealmInstant
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Date
import java.util.Locale


@Composable
fun JournalingScreenComposable() {
    val viewModel: JournalingViewModel = hiltViewModel()
    val data by viewModel.data

    JournalingScreen(
        data = data,
        filtered = viewModel.filtered.value,
        title = viewModel.title.value,
        objectId = viewModel.objectId.value,
        onTitleChanged = { viewModel.updateTitle(title = it) },
        onObjectIdChanged = { viewModel.updateObjectId(id = it) },
        onInsertClicked = { viewModel.insertNote() },
        onUpdateClicked = { viewModel.updateNote() },
        onDeleteClicked = { viewModel.deleteNote() },
        onFilterClicked = { viewModel.filterData() }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun JournalingScreen(
    data: List<Note>,
    filtered: Boolean,
    title: String,
    objectId: String,
    onTitleChanged: (String) -> Unit,
    onObjectIdChanged: (String) -> Unit,
    onInsertClicked: () -> Unit,
    onUpdateClicked: () -> Unit,
    onDeleteClicked: () -> Unit,
    onFilterClicked: () -> Unit
){
    Scaffold (
        content = {
            JournalingContent(
                data = data,
                filtered = filtered,
                title = title,
                objectId = objectId,
                onTitleChanged = onTitleChanged,
                onObjectIdChanged = onObjectIdChanged,
                onInsertClicked = onInsertClicked,
                onUpdateClicked = onUpdateClicked,
                onDeleteClicked = onDeleteClicked,
                onFilterClicked = onFilterClicked
            )
        }
    )
}

@Composable
fun JournalingContent(
    data: List<Note>,
    filtered: Boolean,
    title: String,
    objectId: String,
    onTitleChanged: (String) -> Unit,
    onObjectIdChanged: (String) -> Unit,
    onInsertClicked: () -> Unit,
    onUpdateClicked: () -> Unit,
    onDeleteClicked: () -> Unit,
    onFilterClicked: () -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column {
            Row {
                TextField(
                    modifier = Modifier.weight(1f),
                    value = objectId,
                    onValueChange = onObjectIdChanged,
                    placeholder = { Text(text = "Object ID")}
                )
                Spacer(modifier = Modifier.width(12.dp))

                TextField(
                    modifier = Modifier.weight(1f),
                    value = title,
                    onValueChange = onTitleChanged,
                    placeholder = { Text(text = "Title")}

                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(state = rememberScrollState()),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(onClick = onInsertClicked) {
                    Text(text = "Add")
                }
                Spacer(modifier = Modifier.width(6.dp))

                Button(onClick = onUpdateClicked) {
                    Text(text = "Update")
                }
                Spacer(modifier = Modifier.width(6.dp))

                Button(onClick = onDeleteClicked) {
                    Text(text = "Delete")
                }
                Spacer(modifier = Modifier.width(6.dp))

                Button(onClick = onFilterClicked) {
                    Text(text = if(filtered) "Clear" else "Filter")
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(items = data, key = { it._id.toHexString() }) {
                NoteView (
                    id = it._id.toHexString(),
                    title = it.title,
                    timestamp = it.timestamp
                )
            }
        }
    }
}

@Composable
fun NoteView(id:String, title: String, timestamp: RealmInstant) {
    Row (modifier = Modifier.padding(bottom = 24.dp)){
        Column (modifier = Modifier.weight(1f)){
            Text(
                text = title,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold
                )
            )
            SelectionContainer {
                Text(
                    text = id,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ){
            Text(
                text = SimpleDateFormat("hh:mm a", Locale.getDefault())
                    .format(Date.from(timestamp.toInstant())).uppercase(),
                style = TextStyle (
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}

fun RealmInstant.toInstant(): Instant {
    val sec: Long = this.epochSeconds
    val nano: Int = this.nanosecondsOfSecond
    return if (sec >= 0) {
        Instant.ofEpochSecond(sec, nano.toLong())
    } else {
        Instant.ofEpochSecond(sec - 1, 1_000_000 + nano.toLong())
    }
}