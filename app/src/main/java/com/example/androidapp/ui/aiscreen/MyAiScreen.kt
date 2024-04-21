package com.example.androidapp.ui.aiscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.modifier.modifierLocalConsumer
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

    return when (userInput) {
        "hello", "hi" -> "Hello! How can I assist you today?"
        "how are you?" -> "I'm just a bot, but I'm doing fine! How about you?"
        "Am I eating too much?" -> "It's important to listen to your body's hunger and fullness cues. Consulting with a healthcare professional, such as a registered dietitian, can help you understand what a balanced and appropriate amount of food looks like for your individual needs."
        "Am I eating too little?" -> "If you're concerned about your food intake, it's crucial to seek guidance from a healthcare provider. Eating too little can have serious health consequences and may indicate an eating disorder that requires treatment."
        "Do I deserve to eat this?" -> "Yes, you deserve to nourish your body with food that supports your health and well-being. Challenge any negative thoughts about deserving or not deserving food, and remind yourself that everyone deserves to eat."
        "Will I gain weight if I eat this?" -> "Weight gain is a complex process influenced by various factors beyond individual meals. Instead of focusing solely on weight, consider how food nourishes your body and provides energy for daily activities."
        "What will people think if they see me eating?" -> "Remember that your worth isn't determined by others' opinions. It's okay to eat in front of others, and most people won't judge you for nourishing yourself."
        "How many calories are in this?" -> "While it's natural to be curious about nutrition, obsessing over calorie counts can contribute to unhealthy eating patterns. Focus on nourishing your body with a balanced variety of foods rather than fixating on numbers."
        "Do I look fat?" -> "While it's natural to be curious about nutrition, obsessing over calorie counts can contribute to unhealthy eating patterns. Focus on nourishing your body with a balanced variety of foods rather than fixating on numbers."
        "Why can't I stop eating?" -> "Binge eating can be a coping mechanism for dealing with emotions or stress. Seeking support from a therapist or counselor can help you explore the underlying reasons behind your eating behaviors and develop healthier coping strategies."
        "Why can't I stick to my meal plan?" -> "Recovery from an eating disorder can be challenging, and setbacks are common. Be gentle with yourself and seek support from a treatment team, including a therapist, dietitian, and medical provider, to help you navigate the recovery process."
        "Am I worthy of love and acceptance regardless of my weight?" -> "Yes, absolutely. Your worth as a person is not determined by your weight or appearance. Focus on cultivating self-compassion and accepting yourself for who you are beyond your body."
        "How can I hide my eating habits from others?" -> "Hiding your eating habits can perpetuate feelings of shame and isolation. Opening up to trusted friends, family members, or a therapist about your struggles can provide support and alleviate some of the burden of secrecy."
        "Will exercising more make up for what I ate?" -> "Exercise should be approached as a means of enhancing overall health and well-being, rather than as a way to compensate for food intake. It's important to engage in physical activity that you enjoy and that feels good for your body, rather than using it as a punishment for eating."
        "Why do I feel guilty after eating?" -> "Feelings of guilt after eating are common among individuals with eating disorders. Remember that food is not inherently good or bad, and it's normal and necessary to eat to nourish your body. Working with a therapist can help you explore and challenge these feelings of guilt."
        "Do I have control over my eating habits?" -> "Eating disorders often involve feelings of loss of control around food. It's essential to recognize that recovery is possible and that with support and treatment, you can regain a sense of balance and agency in your eating habits."
        "Will losing weight make me happier?" -> "While society often promotes the idea that weight loss leads to happiness, true happiness and fulfillment come from factors unrelated to body size. Pursuing activities and relationships that bring you joy and fulfillment can contribute to your overall well-being more than focusing solely on weight loss."
        "Why do I binge when I feel stressed?" -> "Binge eating often serves as a coping mechanism for dealing with difficult emotions, such as stress. Learning alternative coping strategies, such as mindfulness, self-care, and reaching out for support, can help you manage stress in healthier ways."
        "Why do I feel so out of control around food?" -> "Feeling out of control around food is a common experience for individuals with eating disorders. It's essential to seek professional help to address the underlying psychological and emotional factors contributing to this sense of loss of control."
        "What's wrong with me that I can't just eat normally?" -> "Eating disorders are complex mental health conditions influenced by a combination of genetic, biological, psychological, and environmental factors. It's not a reflection of personal weakness or failure. With proper treatment and support, recovery is possible."
        "Will I ever recover from this?" -> "Recovery from an eating disorder is possible, and many individuals go on to lead fulfilling lives free from the grip of their disorder. It's essential to have patience and persistence in seeking treatment and support from qualified professionals."
        "How can I overcome these destructive thoughts and behaviors?" -> "Overcoming destructive thoughts and behaviors associated with eating disorders often requires comprehensive treatment, including therapy, nutritional counseling, and possibly medication. Surrounding yourself with a supportive treatment team and engaging in self-care practices can help you work towards recovery."
        else -> "I'm sorry, I didn't understand that."
    }
}

// Model class for chat messages
data class Message(val sender: String, val content: String)

// Composable for displaying a single message
@Composable
fun MessageItem(message: Message) {
    //Card (
      //  modifier = Modifier.background(color = Color.Blue)

    //) {
    val backgroundColor = if (message.sender == "User") {
        Color.Blue // Color for user messages
    } else {
        Color.Green // Color for bot messages
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (message.sender == "User") Arrangement.End else Arrangement.Start
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            contentAlignment = if (message.sender == "User") Alignment.TopEnd else Alignment.TopStart
        ) {
                Card(
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = message.content,
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
