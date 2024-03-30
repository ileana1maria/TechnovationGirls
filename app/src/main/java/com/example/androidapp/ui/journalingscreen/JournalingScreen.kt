package com.example.myapplication.screen

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androidapp.ui.journalingscreen.JournalingViewModel
import com.example.androidapp.ui.journalingscreen.MoodComposable
import com.example.androidapp.ui.journalingscreen.QuestionMarkWithTooltip
import com.example.androidapp.ui.journalingscreen.SymptomsComposable
import com.example.androidapp.ui.journalingscreen.model.Note
import com.example.androidapp.ui.theme.DarkGreyGreenColor
import com.example.androidapp.ui.theme.JournalingCompColor


@Composable
fun JournalingScreenComposable() {
    val viewModel: JournalingViewModel = hiltViewModel()
    val data by viewModel.data

    JournalingScreen(
        data = data,
        filtered = viewModel.filtered.value,
        title = viewModel.title.value,
        journal = viewModel.journal.value,
        objectId = viewModel.objectId.value,
        onTitleChanged = { viewModel.updateTitle(title = it) },
        onJournalChanged = {viewModel.updateJournal(journal = it)},
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
    journal: String,
    objectId: String,
    onTitleChanged: (String) -> Unit,
    onJournalChanged: (String) -> Unit,
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
                journal = journal,
                objectId = objectId,
                onTitleChanged = onTitleChanged,
                onJournalChanged = onJournalChanged,
                onObjectIdChanged = onObjectIdChanged,
                onInsertClicked = onInsertClicked,
                onUpdateClicked = onUpdateClicked,
                onDeleteClicked = onDeleteClicked,
                onFilterClicked = onFilterClicked
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JournalingContent(
    data: List<Note>,
    filtered: Boolean,
    title: String,
    journal: String,
    objectId: String,
    onTitleChanged: (String) -> Unit,
    onJournalChanged: (String) -> Unit,
    onObjectIdChanged: (String) -> Unit,
    onInsertClicked: () -> Unit,
    onUpdateClicked: () -> Unit,
    onDeleteClicked: () -> Unit,
    onFilterClicked: () -> Unit
) {
    // This holds basically everything on the screen
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        // This column holds the 2 text fields and the row of buttons
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()) // Enable scrolling
                .padding(5.dp)
        ) {
            // This holds the two Mood and Symptoms cards
            Column (
                modifier = Modifier
                    .fillMaxSize()
            ) {
                MoodComposable()
                Spacer(modifier = Modifier.width(10.dp))
                SymptomsComposable()
                Spacer(modifier = Modifier.width(10.dp))
            }
            // This row is so that the text fields are next to each other horizontally
            Row {

                var expanded by remember { mutableStateOf(false) }
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = JournalingCompColor,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable { expanded = !expanded }, // Toggle expansion on click
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .animateContentSize() // Enables smooth size transitions
                    ) {
//                Text(text = "Your journal of the day", style = TextStyle(fontWeight = FontWeight.Bold))

                        // Title (editable by user)
                        TextField(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = Color.Transparent)
                                .padding(start = 5.dp, top = 10.dp),
                            value = title,
                            onValueChange = onTitleChanged,
                            placeholder = {
                                Text(
                                    "Your journal of the day",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            },
                            textStyle = TextStyle(color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold),
                            shape = RoundedCornerShape(8.dp), // Customize the shape (rounded corners)
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent, // Set background color
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent, // Remove underline when focused
                                unfocusedIndicatorColor = Color.Transparent, // Remove underline when not focused
                            )
                        )

                        Spacer(modifier = Modifier.height(2.dp))

                        // Content (editable by user)
                        TextField(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = Color.Transparent)
                                .padding(start = 8.dp),
                            value = journal,
                            onValueChange = onJournalChanged,
                            placeholder = {
                                Text (
                                    "Start writing...",
                                    color = DarkGreyGreenColor,
                                    fontSize = 15.sp
                                )
                            },
                            textStyle = TextStyle(color = DarkGreyGreenColor, fontSize = 15.sp),  // Set the desired text color

                            maxLines = if (expanded) Int.MAX_VALUE else 1 ,// Expandable behavior
                            shape = RoundedCornerShape(8.dp), // Customize the shape (rounded corners)
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent, // Set background color
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent, // Remove underline when focused
                                unfocusedIndicatorColor = Color.Transparent, // Remove underline when not focused
                            )
                        )
                        QuestionMarkWithTooltip()
                    }
                }


                // This is the first text field that has the object id
                TextField(
                    modifier = Modifier.weight(1f),
                    value = objectId,
                    onValueChange = onObjectIdChanged,
                    placeholder = { Text(text = "Object ID")}
                )
                Spacer(modifier = Modifier.width(12.dp))


//                // This is the second text field that has the Title text field
//                TextField(
//                    modifier = Modifier.weight(1f),
//                    value = title,
//                    onValueChange = onTitleChanged,
//                    placeholder = { Text(text = "Title")}
//
//                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // This is the row that has the buttons
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
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

