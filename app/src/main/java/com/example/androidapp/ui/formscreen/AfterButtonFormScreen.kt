package com.example.androidapp.ui.formscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidapp.ui.theme.ButtonGreen
import com.example.androidapp.ui.theme.IntroGreen
import com.example.androidapp.ui.theme.NoGreen
import com.example.androidapp.ui.theme.RarelyGreen
import com.example.androidapp.ui.theme.SometimesGreen

@Composable
fun AfterButtonFormScreen() {
    val questionList = listOf("1. I think about food constantly.","2. I eat in secret.", "3. I eat even when I am not hungry.", "4. I eat very quickly and am not aware how much I have eaten.", "5. I am very self-conscious about eating in social situations.", "6. I often try new diets and/or exercise plans.", "7. I feel guilty about eating.", "8.I am very concerned about my weight.", "9. I try to skip meals or avoid eating for the entire day.", "10. I lie to others about how much or little I eat.", "11. Other people have made concerned comments about my eating habits.", "12. It is difficult for me to concentrate because I am thinking about food.", "13. I hide food.", "14. I gain and lose weight frequently.", "15. I withdraw from my friends and avoid social situations.", "16. I wear baggy clothes to hide my weight loss, or tight clothes to show off my weight loss.", "17. I do not like myself or the way I look.", "18. I feel fat even though others think I am thin.", "19. I feel that I can never eat normally.", "20. I am unable to stop binging and purging even though I want to quit."
    )
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp, bottom = 75.dp)
    ){
        items(questionList) {question ->
            QuizSquare(question)
        }
    }
}

@Composable
fun QuizSquare(
    question: String,
) {
    Text(
        text = question,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        var isYesButtonOutlined by remember { mutableStateOf(false) }
        var isSometimesButtonOutlined by remember { mutableStateOf(false) }
        var isRarelyButtonOutlined by remember{ mutableStateOf(false) }
        var isNoButtonOutlined by remember { mutableStateOf(false) }
        Row {
            //YES BUTTON
            Button(
                onClick = {
                    isYesButtonOutlined = true
                    isSometimesButtonOutlined = false
                    isRarelyButtonOutlined = false
                    isNoButtonOutlined = false
                },
                shape = RoundedCornerShape(17.dp),
                colors = ButtonDefaults.buttonColors(containerColor = IntroGreen, contentColor = Color.Black),
                modifier = Modifier
                    .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(0.9f)
                    .border(
                        border = BorderStroke(
                            3.dp,
                            if (isYesButtonOutlined) Color.Black else Color.Transparent
                        ),
                        shape = RoundedCornerShape(17.dp)
                    )
            ) {
                Text(
                    text = "YES",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(top = 3.dp, bottom = 3.dp)
                )
            }
        }
        Row {
            //SOMETIMES BUTTON
            Button(
                onClick = {
                    isSometimesButtonOutlined = true
                    isYesButtonOutlined = false
                    isRarelyButtonOutlined = false
                    isNoButtonOutlined = false
                },
                shape = RoundedCornerShape(17.dp),
                colors = ButtonDefaults.buttonColors(containerColor = SometimesGreen, contentColor = Color.Black),
                modifier = Modifier
                    .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(0.9f)
                    .border(
                        border = BorderStroke(
                            3.dp,
                            if(isSometimesButtonOutlined) Color.Black else Color.Transparent
                        ),
                        shape = RoundedCornerShape(17.dp)
                    )
            ) {
                Text(
                    text = "SOMETIMES",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(top = 3.dp, bottom = 3.dp)
                )
            }
        }
        Row {
            //RARELY BUTTON
            Button(
                onClick = {
                    isRarelyButtonOutlined = true
                    isSometimesButtonOutlined = false
                    isYesButtonOutlined = false
                    isNoButtonOutlined = false
                } ,
                shape = RoundedCornerShape(17.dp),
                colors = ButtonDefaults.buttonColors(containerColor = RarelyGreen, contentColor = Color.Black),
                modifier = Modifier
                    .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(0.9f)
                    .border(
                        border = BorderStroke(
                            3.dp,
                            if(isRarelyButtonOutlined) Color.Black else Color.Transparent
                        ),
                        shape = RoundedCornerShape(17.dp)
                    )
            ) {
                Text(
                    text = "RARELY",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(top = 3.dp, bottom = 3.dp)
                )
            }
        }
        Row {
            //NO BUTTON
            Button(
                onClick = {
                    isNoButtonOutlined = true
                    isSometimesButtonOutlined = false
                    isRarelyButtonOutlined = false
                    isYesButtonOutlined = false
                },
                shape = RoundedCornerShape(17.dp),
                colors = ButtonDefaults.buttonColors(containerColor = NoGreen, contentColor = Color.Black),
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(0.9f)
                    .border(
                        border = BorderStroke(
                            3.dp,
                            if(isNoButtonOutlined) Color.Black else Color.Transparent
                        ),
                        shape = RoundedCornerShape(17.dp)
                    )
            ) {
                Text(
                    text = "NO",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 3.dp, bottom = 3.dp)
                )
            }
        }
    }
}