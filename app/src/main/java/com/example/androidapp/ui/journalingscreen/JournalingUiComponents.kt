package com.example.androidapp.ui.journalingscreen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun JournalingUiComposable() {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        MoodComposable()
        Spacer(modifier = Modifier.width(10.dp))
        SymptomsComposable()
        Spacer(modifier = Modifier.width(10.dp))
        JournalOfTheDayComposable(
            title = " ",
            content = " ")
    }
}


@Composable
fun MoodComposable () {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 400.dp, height = 200.dp)
            .padding(10.dp)
    ) {
        Text(text = "Mood")
    }
}

@Composable
fun SymptomsComposable () {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 400.dp, height = 200.dp)
            .padding(10.dp)
    ) {
        Text(text = "Symptoms")
    }
}

@Composable
fun JournalOfTheDayComposable (title: String, content: String) {

    var expanded by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { expanded = !expanded }, // Toggle expansion on click
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize() // Enables smooth size transitions
        ) {
//                Text(text = "Your journal of the day", style = TextStyle(fontWeight = FontWeight.Bold))
//                Spacer(modifier = Modifier.height(8.dp))

            // Title (editable by user)
            TextField(
                value = title,
                onValueChange = { /* Handle title changes */ },
                label = { Text("Your journal of the day") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Content (editable by user)
            TextField(
                value = content,
                onValueChange = { /* Handle content changes */ },
                label = { Text("Start writing...") },
                maxLines = if (expanded) Int.MAX_VALUE else 1 // Expandable behavior
            )
        }
    }
}