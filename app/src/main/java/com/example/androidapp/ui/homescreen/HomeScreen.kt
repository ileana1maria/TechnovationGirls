package com.example.androidapp.ui.homescreen

import androidx.compose.runtime.Composable
import com.example.androidapp.ui.profile.ProfileIcon

@Composable
fun HomeScreen(onNavigateToProfileScreen: () -> Unit) {

    ProfileIcon {
        onNavigateToProfileScreen()
    }

}