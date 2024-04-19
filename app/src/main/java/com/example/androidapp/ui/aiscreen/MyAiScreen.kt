package com.example.androidapp.ui.aiscreen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyAiScreen() {

    Scaffold(
        floatingActionButton = {
            MessageTextField()
        },
        modifier = Modifier.padding(start = 5.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            Card {
                Text(text = "Gigi Haddid")
            }
        }
    }
}

@Composable
fun MyIcon(){
    val iconModifier = Modifier
        .size(30.dp)
        .offset(x = 347.dp, y = 12.dp)
        .clickable { }

    Icon(
        imageVector = Icons.Default.Send,
        contentDescription = "Message icon",
        modifier = iconModifier
    )
}

@Composable
fun MessageTextField(){
    var textFieldState by remember {
        mutableStateOf("")
    }
    TextField(
        value = textFieldState,
        onValueChange = {
            textFieldState = it
        },
        placeholder = {
            Text(
                "Message",
                color = Color.DarkGray,
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 5.dp)
            )
        },
        shape = RoundedCornerShape(8.dp), // Customize the shape (rounded corners)
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 70.dp)
    )
    MyIcon()
}