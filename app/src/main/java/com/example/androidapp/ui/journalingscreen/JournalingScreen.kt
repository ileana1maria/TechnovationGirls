package com.example.androidapp.ui.journalingscreen

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.androidapp.R
import com.example.androidapp.ui.journalingscreen.model.Note
import com.example.androidapp.ui.theme.DarkGreyGreenColor
import com.example.androidapp.ui.theme.JournalingCompColor
import com.example.androidapp.ui.theme.MoodCompColor
import com.example.androidapp.ui.theme.NoteColor1
import com.example.androidapp.ui.theme.NoteColor2
import com.example.androidapp.ui.theme.NoteColor3
import com.example.androidapp.ui.theme.NoteColor4
import com.example.androidapp.ui.theme.NoteColor5
import com.example.androidapp.ui.theme.NoteColor6


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun JournalingScreenComposable(onNavigateToNoteScreen: () -> Unit) {

    Scaffold (
        floatingActionButton = {
            JFloatingActionButton {
                onNavigateToNoteScreen()
            }
        },
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(start = 10.dp, top = 30.dp, end = 10.dp, bottom = 170.dp)
        ) {

            val value = ""
            TextField(
                modifier = Modifier
                    .fillMaxSize(),
                value = value,
                placeholder = {
                    Text(
                        "Search",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                onValueChange = {},

                shape = RoundedCornerShape(10.dp),

                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent, // Remove underline when focused
                    unfocusedIndicatorColor = Color.Transparent, // Remove underline when not focused
                )
            )

            Spacer(modifier = Modifier.height(30.dp))

            NotePart(
                title = "Today was a great day",
                date = "16 April",
                content = "My day started like usual, woke up, went to school, came back home and ate. However, ",
                color = NoteColor1,
                id = R.drawable.mood1
            )

            Spacer(modifier = Modifier.height(15.dp))

            NotePart(
                title = "Worst day of my life!",
                date = "15 April",
                content = "Not only did I wake up with nausea but also with severe stomach ache. ",
                color = NoteColor2,
                id = R.drawable.mood2
            )

            Spacer(modifier = Modifier.height(15.dp))

            NotePart(
                title = "At the aquarium",
                date = "14 April",
                content = "Today I tried something new and exciting! I went to the aquarium! ",
                color = NoteColor6,
                id = R.drawable.mood6
            )

            Spacer(modifier = Modifier.height(15.dp))

            NotePart(
                title = "The walk",
                date = "13 April",
                content = "I realised that I rarely go on walks, so I decided to try it out and it was actually really enjoyable",
                color = NoteColor4,
                id = R.drawable.mood4
            )

            Spacer(modifier = Modifier.height(15.dp))

            NotePart(
                title = "School",
                date = "12 April",
                content = "I want to address one of my biggest problems that being school",
                color = NoteColor5,
                id = R.drawable.mood5
            )

            Spacer(modifier = Modifier.height(15.dp))

            NotePart(
                title = "Nausea",
                date = "11 April",
                content = "I realised that journaling this way really helps mentally",
                color = NoteColor2,
                id = R.drawable.mood2
            )

            Spacer(modifier = Modifier.height(15.dp))

            NotePart(
                title = "No one to help me",
                date = "10 April",
                content = "It's been difficult to remain consistent in doing this, but I am trying my best",
                color = NoteColor2,
                id = R.drawable.mood2
            )

            Spacer(modifier = Modifier.height(15.dp))

            NotePart(
                title = "All by myself",
                date = "9 April",
                content = "Dear diary,I am writing because you are my only hope. I am really in a dark zone right now.",
                color = NoteColor2,
                id = R.drawable.mood2
            )

            Spacer(modifier = Modifier.height(15.dp))

            NotePart(
                title = "Trying out this app!",
                date = "8 April",
                content = "I am really excited to use this app! It looks really calming too!",
                color = NoteColor2,
                id = R.drawable.mood5
            )
        }
    }
}

@Composable
fun NotePart(
    title: String,
    date: String,
    content: String,
    color: Color,
    id: Int
) {
    Card (
        modifier = Modifier
            .size(height = 75.dp, width = 600.dp),
        colors = CardDefaults.cardColors(
            containerColor = color,
        )

    ) {

        Column (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row {
                Image(
                    painter = painterResource(id = id),
                    contentDescription = "Image describing the mood",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(start = 3.dp, top = 15.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 15.dp)
                    )
                }
            }

            Row (
                modifier = Modifier.padding(bottom = 5.dp, start = 45.dp)
            ){
                Text(
                    text = date,
                    color = Color.White,
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = content,
                    maxLines = 1,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun JFloatingActionButton(
    onClick: () -> Unit,
) {
    FloatingActionButton(
        onClick = { onClick() },
        modifier = Modifier
            .padding(bottom = 70.dp)
            .size(80.dp)
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}