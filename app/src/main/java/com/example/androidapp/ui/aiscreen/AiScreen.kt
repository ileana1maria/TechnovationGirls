package com.example.androidapp.ui.aiscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.androidapp.ui.profile.ProfileIcon

@Composable
fun AiScreen(onNavigateToProfileScreen: () -> Unit) {
    Column {
        ProfileIcon {
            onNavigateToProfileScreen()
        }
        MyAiScreen()
    }

}