package com.example.androidapp.ui.trackprogressscreen

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidapp.R
import com.example.androidapp.ui.theme.EmojiCardColor
import com.example.androidapp.ui.theme.TypCard1
import com.example.androidapp.ui.theme.TypCard2
import com.example.androidapp.ui.theme.TypCard3

@Composable
fun TrackProgressScreen() {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 90.dp)
            .verticalScroll(rememberScrollState())
    )
    {
        Graph()

        Spacer(modifier = Modifier.height(15.dp))

        OrderCard(
            title = "Energy",
            id = R.drawable.sun,
            contentDescription = "Energy card",
            percentage = "78%",
            modifier = Modifier
                .padding(start = 185.dp, top = 5.dp)
                .size(height = 65.dp, width = 65.dp),
            color = TypCard1
        )

        Spacer(modifier = Modifier.height(15.dp))

        OrderCard(
            title = "Happiness",
            id = R.drawable.happy2,
            contentDescription = "Happiness card",
            percentage = "90%",
            modifier = Modifier
                .padding(start = 140.dp, top = 6.dp)
                .size(height = 55.dp, width = 55.dp),
            color = TypCard2
        )

        Spacer(modifier = Modifier.height(15.dp))

        OrderCard(
            title = "Stress",
            id = R.drawable.cloud,
            contentDescription = "Stress card",
            percentage = "20%",
            modifier = Modifier
                .padding(start = 200.dp, top = 5.dp, end = 5.dp)
                .size(height = 60.dp, width = 60.dp),
            color = TypCard3
        )
    }
}


@Composable
fun Graph() {
    Image(
        painter = painterResource(id = R.drawable.grafictyp),
        contentDescription = "track your progress graph",
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 25.dp)
    )
}

@Composable
fun OrderCard(
    title: String,
    id: Int,
    contentDescription: String,
    percentage: String,
    modifier: Modifier,
    color: Color
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .padding(start = 10.dp, end = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = color
        ),


    ){
        Column {
            Row {
                Text(
                    text = title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )

                Image(
                    painter = painterResource(id = id),
                    contentDescription = contentDescription,
                    modifier = modifier
                )
            }

            Row {
                Text(
                    text = percentage,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(start = 310.dp, end = 10.dp, bottom = 10.dp, top = 5.dp)
                )
            }
        }
    }
}