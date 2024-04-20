package com.example.androidapp.ui.journalingscreen

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidapp.ui.journalingscreen.model.Note
import com.example.androidapp.ui.theme.DarkGreyGreenColor
import com.example.androidapp.ui.theme.JournalingCompColor


@Composable
fun NoteScreen(onNavigateToJournalingScreen: () -> Unit) {
    val viewModel: JournalingViewModel = hiltViewModel()
    val data by viewModel.data

    JournalingScreen(
        data = data,
        title = viewModel.title.value,
        journal = viewModel.journal.value,
        objectId = viewModel.objectId.value,
        onTitleChanged = { viewModel.updateTitle(title = it) },
        onJournalChanged = {viewModel.updateJournal(journal = it)},
        onObjectIdChanged = { viewModel.updateObjectId(id = it) },
        onInsertClicked = { viewModel.insertNote() },
        onUpdateClicked = { viewModel.updateNote() },
        onNavigateToJournalingScreen
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun JournalingScreen(
    data: List<Note>,
    title: String,
    journal: String,
    objectId: String,
    onTitleChanged: (String) -> Unit,
    onJournalChanged: (String) -> Unit,
    onObjectIdChanged: (String) -> Unit,
    onInsertClicked: () -> Unit,
    onUpdateClicked: () -> Unit,
    onNavigateToJournalingScreen: () -> Unit
){
    Scaffold (
        content = {
            JournalingContent(
                data = data,
                title = title,
                journal = journal,
                objectId = objectId,
                onTitleChanged = onTitleChanged,
                onJournalChanged = onJournalChanged,
                onObjectIdChanged = onObjectIdChanged,
                onInsertClicked = onInsertClicked,
                onUpdateClicked = onUpdateClicked,
                onNavigateToJournalingScreen

            )
        }
    )
}

@Composable
fun JournalingContent(
    data: List<Note>,
    title: String,
    journal: String,
    objectId: String,
    onTitleChanged: (String) -> Unit,
    onJournalChanged: (String) -> Unit,
    onObjectIdChanged: (String) -> Unit,
    onInsertClicked: () -> Unit,
    onUpdateClicked: () -> Unit,
    onNavigateToJournalingScreen: () -> Unit
) {
    // This holds basically everything on the screen
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 150.dp,),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        // This column holds the 2 text fields and the row of buttons
        Column(
            modifier = Modifier
                .fillMaxSize()
                //.verticalScroll(rememberScrollState()) // Enable scrolling
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
                            textStyle = TextStyle(
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            ),
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
                                Text(
                                    "Start writing...",
                                    color = DarkGreyGreenColor,
                                    fontSize = 15.sp
                                )
                            },
                            textStyle = TextStyle(
                                color = DarkGreyGreenColor,
                                fontSize = 15.sp
                            ),  // Set the desired text color

                            maxLines = if (expanded) Int.MAX_VALUE else 1,// Expandable behavior
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
            }
        }
        Button(
            onClick = {onNavigateToJournalingScreen()},
            modifier = Modifier
                .fillMaxWidth() // Expand to full width
                .padding(top = 8.dp, start = 15.dp, end = 15.dp) // Add top padding
        ) {
            Text(text = "Save")
        }
//        Button(
//            onClick = { },
//            modifier = Modifier
//                .fillMaxWidth() // Expand to full width
//                .padding(top = 8.dp, start = 15.dp, end = 15.dp) // Add top padding
//        ) {
//            Text(text = "Save")
//        }

//        LazyColumn(modifier = Modifier.weight(1f)) {
//            items(items = data, key = { it._id.toHexString() }) {
//                NoteView (
//                    id = it._id.toHexString(),
//                    title = it.title,
//                    journal = it.journal,
//                    timestamp = it.timestamp
//                )
//            }
//        }
    }
}


//@Composable
//fun NoteView(
//    id:String,
//    title: String,
//    journal: String,
//    timestamp: RealmInstant
//) {
//    Row (
//        modifier = Modifier.padding(bottom = 24.dp)
//    ) {
//        Column (
//            modifier = Modifier.weight(1f)
//        ) {
//            Text(
//                text = title,
//                style = TextStyle(
//                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
//                    fontWeight = FontWeight.Bold
//                )
//            )
//            Text(
//                text = journal,
//                style = TextStyle(
//                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
//                    fontWeight = FontWeight.Normal
//                )
//            )
//            SelectionContainer {
//                Text(
//                    text = id,
//                    style = TextStyle(
//                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
//                        fontWeight = FontWeight.Normal
//                    )
//                )
//            }
//        }
//        Column (
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.End
//        ) {
//            Text(
//                text = SimpleDateFormat("hh:mm a", Locale.getDefault())
//                    .format(Date.from(timestamp.toInstant())).uppercase(),
//                style = TextStyle (
//                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
//                    fontWeight = FontWeight.Normal
//                )
//            )
//        }
//    }
//}
//
//fun RealmInstant.toInstant(): Instant {
//    val sec: Long = this.epochSeconds
//    val nano: Int = this.nanosecondsOfSecond
//    return if (sec >= 0) {
//        Instant.ofEpochSecond(sec, nano.toLong())
//    } else {
//        Instant.ofEpochSecond(sec - 1, 1_000_000 + nano.toLong())
//    }
//}