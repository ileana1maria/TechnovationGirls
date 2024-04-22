package com.example.androidapp.ui.formscreen

import androidx.compose.runtime.Composable
import com.example.androidapp.ui.profile.ProfileIcon

@Composable
fun FormScreen(onNavigateToProfileScreen: () -> Unit) {
    ProfileIcon {
        onNavigateToProfileScreen()
    }

}