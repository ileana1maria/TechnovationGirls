package com.example.androidapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidapp.MainActivity
import com.example.androidapp.R
import com.example.androidapp.ui.theme.AndroidAppTheme
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidAppTheme {
                SplashScreen()
            }
        }
    }

    @Composable
    private fun SplashScreen() {
        LaunchedEffect(key1 = true) {
            delay(2000)
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center,

        ) {
            Image(
                painter = painterResource(id = R.drawable.app_icon2),
                modifier = Modifier.size(100.dp),
                contentDescription = null
            )
        }
    }
}