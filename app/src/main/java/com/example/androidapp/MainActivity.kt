package com.example.androidapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.androidapp.ui.navbar.BottomNavigationBar
import com.example.androidapp.ui.navbar.NavItem
import com.example.androidapp.ui.navbar.Navigation
import com.example.androidapp.ui.theme.AndroidAppTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAppTheme {
               val navController = rememberNavController()

                Scaffold (
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                NavItem(
                                    name = "Form",
                                    route = "form",
                                    icon = Icons.Default.List
                                ),
                                NavItem(
                                    name = "Ai",
                                    route = "ai",
                                    icon = Icons.Default.Face
                                ),
                                NavItem(
                                    name = "Home",
                                    route = "home",
                                    icon = Icons.Default.Home
                                ),
                                NavItem(
                                    name = "Journaling",
                                    route = "journaling" ,
                                    icon = Icons.Default.AccountBox
                                ),
                                NavItem(
                                    name = "Progress",
                                    route = "trackprogress",
                                    icon = Icons.Default.CheckCircle
                                ),

                            ),
                            navController = navController,
                            modifier = Modifier,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    },
                    containerColor = Color.White

                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}