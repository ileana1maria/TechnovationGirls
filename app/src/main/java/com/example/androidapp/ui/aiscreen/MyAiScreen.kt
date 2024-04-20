package com.example.androidapp.ui.aiscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyAiScreen() {
    val (messages, setMessages) = remember { mutableStateOf(listOf<Message>()) }
    val (textFieldState, setTextFieldState) = remember { mutableStateOf("") }
    Scaffold(
        floatingActionButton = {
            MessageTextField (
                textFieldState = textFieldState,
                setTextFieldState = setTextFieldState
            ){ newMessages ->
                setMessages(messages + newMessages)
            }
        },
        modifier = Modifier.padding(start = 15.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            Chat(messages, setMessages, textFieldState, setTextFieldState)
        }
    }
}

@Composable
fun MessageTextField(
    textFieldState: String,
    setTextFieldState: (String) -> Unit,
    onNewMessages: (List<Message>) -> Unit
){
    //var textFieldState by remember {
      //  mutableStateOf("")

    Row(verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = textFieldState,
            onValueChange = {
                setTextFieldState(it)
            },
            placeholder = {
                Text(
                    "Message",
                    color = Color.DarkGray,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 70.dp),
            shape = RoundedCornerShape(10.dp)
            //.align(Alignment.Companion.CenterHorizontally)
            //modifier = Modifier.align(Alignment.Bottom)
        )
        MyIcon {
            val userMessage = Message(sender = "User", content = textFieldState)
            onNewMessages.invoke(listOf(userMessage))
            setTextFieldState("")
        }
    }

}

@Composable
fun MyIcon(onClickSend: () -> Unit){
    val iconModifier = Modifier
        .size(30.dp)
        .offset(x = 341.dp, y = 12.dp)
        .clickable { onClickSend.invoke() }

    Icon(
        imageVector = Icons.Default.Send,
        contentDescription = "Message icon",
        modifier = iconModifier
    )
}

@Composable
fun Chat(messages: List<Message>,
         setMessages: (List<Message>) -> Unit,
         textFieldState: String,
         setTextFieldState: (String) -> Unit
) {
    // State to hold chat messages
    //val (messages, setMessages) = remember { mutableStateOf(listOf<Message>()) }
    //val (inputText, setInputText) = remember { mutableStateOf("") }

    //Column(
      //  modifier = Modifier.fillMaxSize()
    //) {
        // Chat messages
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(messages) { message ->
                MessageItem(message)
            }
        }

        // Input field and send button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Button(
                onClick = {
                    // Add user message to the list
                    val userMessage = Message(sender = "User", content = textFieldState)
                    setMessages(messages + userMessage)

                    // Mock AI response
                    val botResponse = getMockBotResponse(textFieldState)
                    val botMessage = Message(sender = "Bot", content = botResponse)
                    setMessages(messages + botMessage)

                    // Clear input field
                    setTextFieldState("")
                }
            ) {
                Text(text = "Send")
            }
        }
}

// Function to generate mock AI responses
fun getMockBotResponse(userInput: String): String {
    // Mock responses based on user input
    return when (userInput.lowercase(Locale.ROOT)) {
        "hello", "hi" -> "Hello! How can I assist you today?"
        "how are you?" -> "I'm just a bot, but I'm doing fine! How about you?"
        else -> "I'm sorry, I didn't understand that."
    }
}

// Model class for chat messages
data class Message(val sender: String, val content: String)

// Composable for displaying a single message
@Composable
fun MessageItem(message: Message) {
    Text(
        text = "${message.sender}: ${message.content}",
        //modifier = Modifier.padding(8.dp)
    )
}