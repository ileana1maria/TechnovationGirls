package com.example.androidapp.ui.aiscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxHeight(0.87f),

        bottomBar = {
            MessageTextField(
                textFieldState = textFieldState,
                setTextFieldState = setTextFieldState
            ) { newMessages ->
                setMessages(messages + newMessages)
            }
        }
    ) {

        Chat(messages, setMessages, textFieldState, setTextFieldState)

    }
}

@Composable
fun MessageTextField(
    textFieldState: String,
    setTextFieldState: (String) -> Unit,
    onNewMessages: (List<Message>) -> Unit
) {
    //var textFieldState by remember {
    //  mutableStateOf("")

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
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
            shape = RoundedCornerShape(10.dp),
            //.align(Alignment.Companion.CenterHorizontally)
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                MyIcon {
                    //val userMessage = Message(sender = "User", content = textFieldState)
                    //onNewMessages.invoke(listOf(userMessage))
                    //setTextFieldState("")
                    // Add user message to the list
                    val userMessage = Message(sender = "User", content = textFieldState)
                    //onNewMessages.invoke(listOf(userMessage))

                    // Mock AI response
                    val botResponse = getMockBotResponse(textFieldState)
                    val botMessage = Message(sender = "Bot", content = botResponse)
                    onNewMessages.invoke(listOf(userMessage, botMessage))

                    // Clear input field
                    setTextFieldState("")
                }
            }
        )

    }

}


@Composable
fun MyIcon(onClickSend: () -> Unit) {
    val iconModifier = Modifier
        .size(30.dp)
        .clickable { onClickSend.invoke() }
        .padding(start = 10.dp)

    Icon(
        imageVector = Icons.Default.Send,
        contentDescription = "Message icon",
        modifier = iconModifier
    )
}

@Composable
fun Chat(
    messages: List<Message>,
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
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(messages) { message ->
            MessageItem(message)
        }
    }
}

// Function to generate mock AI responses
fun getMockBotResponse(userInput: String): String {
    // Mock responses based on user input
    return when (userInput.toLowerCase(Locale.ROOT)) {
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
    Card (
        modifier = Modifier.background(color = Color.Blue)
        //shape = RoundedCorner
    ) {
        Text(
            text = "${message.sender}: ${message.content}",
            modifier = Modifier
                .padding(8.dp)
                .background(color = Color.Transparent)

        )
    }
}