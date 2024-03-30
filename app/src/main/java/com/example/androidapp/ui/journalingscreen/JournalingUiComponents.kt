package com.example.androidapp.ui.journalingscreen

import android.graphics.ColorSpace
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.androidapp.ui.theme.MoodCompColor
import com.example.androidapp.ui.theme.SymptomsCompColor

@Composable
fun MoodComposable () {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MoodCompColor,
        ),
        modifier = Modifier
            .size(width = 400.dp, height = 200.dp)
            .padding(10.dp)
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Mood",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SymptomsComposable () {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = SymptomsCompColor,
        ),
        modifier = Modifier
            .size(width = 400.dp, height = 200.dp)
            .padding(10.dp)
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Symptoms",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun QuestionMarkWithTooltip() {
    var showTooltip by remember { mutableStateOf(false) }

    val iconModifier = Modifier
        .size(30.dp)
        .offset(x = 285.dp, y = 2.dp)
        .clickable { showTooltip = !showTooltip }

    Icon(
        imageVector = Icons.Default.Info,
        contentDescription = "Question Mark",
        modifier = iconModifier
    )

    if (showTooltip) {
        // Display the tooltip when the user clicks the icon
        Box(
            modifier = Modifier
                .offset(x = 100.dp, y = 2.dp) // Adjust the offset as needed
                .background(color = Color.LightGray)
                .padding(8.dp)
//                .align(TopStart) // Align to the top start (left) of the parent
//                .absoluteElevation(4.dp) // Control elevation relative to the navbar
        ) {
            Text(
                "For e.g: How was your day?\n" +
                        "Did you feel stressed today? \n" +
                        "Write down any thoughts you experienced\n"
                        + "that had an impact on your day.",
                fontSize = 10.sp,

            )
        }
    }
}


//@Composable
//fun QuestionMarkWithTooltip() {
//    var showTooltip by remember { mutableStateOf(false) }
//
//    Icon(
//        imageVector = Icons.Default.Info,
//        contentDescription = "Question Mark",
//        modifier = Modifier
//            .size(30.dp)
//            .offset(x = 285.dp, y = 2.dp)
//            .clickable { showTooltip = true }
//    )
//
//    if (showTooltip) {
//        // Display the tooltip when the user clicks the icon
//        Popup(
//            alignment = Alignment.TopStart,
//            offset = IntOffset(x = 500, y = 500) // Adjust the offset as needed
//        ) {
//            Box(
//                modifier = Modifier
//                    .size(100.dp)
//                    .background(color = Color.LightGray)
//            ) {
//                Text("Click for more information",
//                    style = MaterialTheme.typography.bodySmall
//                )
//            }
//        }
//    }
//}



