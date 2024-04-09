package com.example.androidapp.ui.formscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androidapp.R
import com.example.androidapp.ui.theme.ButtonGreen
import com.example.androidapp.ui.theme.IntroGreen

@Composable
fun IntroductionScreen(onNavigateToAfterButtonFormScreen: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Welcome to NoteED!",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 23.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 45.dp, bottom = 30.dp)
        )
        Card(
            colors = CardDefaults.cardColors(
                containerColor = IntroGreen,
            ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .size(width = 360.dp, height = 330.dp)
                .padding(15.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Our mission",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 14.dp, top = 12.dp)
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "We created this app to help you overcome eating disorder, through a holistic and virtual approach. \n" +
                            "Discover mindfulness, journaling and track your progress, guided by AI and interesting facts. ",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 14.dp, end = 14.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(15.dp))
        MyButton { onNavigateToAfterButtonFormScreen() }
        //Spacer(modifier = Modifier.padding(5.dp))
        val icon: Painter = painterResource(id = R.drawable.cabbage) // Replace 'my_icon' with the name of your icon resource
        Image(
            painter = icon,
            contentDescription = "Cabbage icon",
            modifier = Modifier.size(110.dp)
        )
    }
}

/*@Composable
fun IntroComposable () {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = IntroGreen,
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .size(width = 360.dp, height = 330.dp)
            .padding(15.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Our mission",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 14.dp, top = 12.dp)
                )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "We created this app to help you overcome eating disorder, through a holistic and virtual approach. \n" +
                        "Discover mindfulness, journaling and track your progress, guided by AI and interesting facts. ",
                fontSize = 23.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 14.dp, end = 14.dp)
            )
        }
    }
    Spacer(modifier = Modifier.padding(15.dp))
    MyButton { onNavigateToAfterButtonFormScreen() }
    //Spacer(modifier = Modifier.padding(5.dp))
    val icon: Painter = painterResource(id = R.drawable.cabbage) // Replace 'my_icon' with the name of your icon resource
    Image(
        painter = icon,
        contentDescription = "Cabbage icon",
        modifier = Modifier.size(110.dp)
    )
}*/

@Composable
fun MyButton(
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = ButtonGreen, contentColor = Color.Black),
        modifier = Modifier
            .padding(top = 34.dp)
            .fillMaxWidth(0.6f)
    ) {
        Text(
            text = "Take our test!",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        )
    }
}

//@Composable
//fun ToAfterButtonFormScreen() {
//    var showAfterButtonForm by remember { mutableStateOf(false) }
//
//    if (showAfterButtonForm) {
//        AfterButtonFormScreen()
//    } else {
//        Button(
//            onClick = { showAfterButtonForm = true },
//            shape = RoundedCornerShape(20.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = ButtonGreen, contentColor = Color.Black),
//            modifier = Modifier
//                .padding(top = 34.dp)
//                .fillMaxWidth(0.6f)
//
//        ) {
//            Text(
//                text = "Take our test!",
//                fontSize = 25.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
//            )
//        }
//    }
//}


/*@Composable
fun CorneredBox(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp
){
    Column {
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "Our mission",
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        end = 10.dp,
                    )
                    .padding(top = 15.dp)
            )
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "We created this app to help you overcome eating disorder, through a holistic and virtual approach. \n" +
                        "Discover mindfulness, journaling and track your progress, guided by AI and interesting facts. ",
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            )
        }
    }
    Spacer(modifier = Modifier.padding(20.dp))
    Button(onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Green, // Change this to the desired button background color
            contentColor = Color.Black // Change this to the desired button text color
        )
    ) {
        Text(text = "Take our test!")

    }
    Spacer(modifier = Modifier.padding(40.dp))
    val icon: Painter = painterResource(id = R.drawable.cabbage) // Replace 'my_icon' with the name of your icon resource
    Image(
        painter = icon,
        contentDescription = "Cabbage icon"
    )
}*/


