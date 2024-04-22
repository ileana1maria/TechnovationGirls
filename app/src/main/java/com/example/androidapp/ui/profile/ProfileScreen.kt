package com.example.androidapp.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidapp.R
import com.example.androidapp.ui.theme.BoxColor
import com.example.androidapp.ui.theme.DarkGreyGreenColor


@Composable
fun ProfileScreenForNavigation() {
    ProfileScreen(
        name = "Marry",
        age = "17",
        gender = "Female",
        email = "",
        password = "************"
    )
}
@Composable
fun ProfileScreen(
    name: String,
    age: String,
    gender: String,
    email: String,
    password: String,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Box (
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column {

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .background(color = BoxColor)
                ) {
                    Text(
                        text = name,
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 27.dp, top = 25.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "profile picture",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 20.dp),
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Column (modifier = Modifier.padding(start = 5.dp)){
                    Text(
                        text = "User Information",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Divider(
                        thickness = 2.dp,
                        color = DarkGreyGreenColor
                    )

                    Text(
                        text = "Name: $name",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Divider(
                        thickness = 1.dp,
                        color = DarkGreyGreenColor
                    )

                    Text(
                        text = "Age: $age",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Divider(
                        thickness = 1.dp,
                        color = DarkGreyGreenColor
                    )

                    Text(
                        text = "Gender: $gender",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Divider(
                        thickness = 1.dp,
                        color = DarkGreyGreenColor
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "Account Information",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Divider(
                        thickness = 2.dp,
                        color = DarkGreyGreenColor
                    )

                    Text(
                        text = "Email: $email",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Divider(
                        thickness = 1.dp,
                        color = DarkGreyGreenColor
                    )

                    Text(
                        text = "Password: $password",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Divider(
                        thickness = 1.dp,
                        color = DarkGreyGreenColor
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(width = 250.dp, height = 60.dp)
                    ,

                    colors = ButtonDefaults.buttonColors(
                        containerColor = BoxColor
                    )
                ) {
                    Text(text = "Retake the test", color = DarkGreyGreenColor)
                }
            }
        }
    }

}