package com.example.androidapp.ui.navbar

import android.content.Intent
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.androidapp.ui.aiscreen.AiScreen
import com.example.androidapp.ui.formscreen.FormScreen
import com.example.androidapp.ui.homescreen.HomeScreen
//import com.example.androidapp.ui.journalingscreen.JournalingActivity

import com.example.androidapp.ui.theme.IconColor
import com.example.androidapp.ui.theme.IndicatorColor
import com.example.androidapp.ui.theme.NavBarColor
import com.example.androidapp.ui.theme.SelectedIconColor
import com.example.androidapp.ui.trackprogressscreen.TrackProgressScreen
import com.example.myapplication.screen.JournalingScreenComposable

//import com.example.androidapp.ui.homescreen.HomeScreen
//import com.example.androidapp.ui.aiscreen.AiScreen
//import com.example.androidapp.ui.formscreen.FormScreen
//import com.example.androidapp.ui.journalingscreen.JournalingScreen
//import com.example.androidapp.ui.trackprogressscreen.TrackProgressScreen




@Composable
fun Navigation(navController: NavHostController) {

    val context = LocalContext.current

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen()
        }

        composable("journaling") {
//            // Start the Journaling Activity
//            val intent = Intent(context, JournalingActivity::class.java)
//            context.startActivity(intent)

            JournalingScreenComposable()
        }

        composable("trackprogress") {
            TrackProgressScreen()
        }

        composable("ai") {
            AiScreen()
        }

        composable("form") {
            FormScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    items: List<NavItem>,
    //need to access the current route
    navController: NavController,
    modifier: Modifier,
    onItemClick: (NavItem) -> Unit

) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomAppBar (
        modifier = modifier,
        containerColor = NavBarColor,
        tonalElevation = 5.dp,
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem (
                selected = selected,
                onClick = { onItemClick(item) },
                alwaysShowLabel = true,
                icon = {
                    Column (horizontalAlignment = CenterHorizontally) {
                        if(item.badgeCount > 0) {
                            BadgedBox (
                                badge = {
                                    Text(text = item.badgeCount.toString())
                                }
                            ) {
                                Icon( imageVector = item.icon, contentDescription = item.name)
                                Text(
                                    text = item.name,
                                    textAlign = TextAlign.Center,
                                    fontSize = 10.sp
                                )
                            }
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name,)
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }, colors = NavigationBarItemDefaults.colors (
                    selectedIconColor = SelectedIconColor,
                    unselectedIconColor = IconColor,
                    indicatorColor = IndicatorColor,

                )
            )
        }
    }
}

