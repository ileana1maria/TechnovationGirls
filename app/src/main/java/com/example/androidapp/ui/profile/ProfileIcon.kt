package com.example.androidapp.ui.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileIcon(function: () -> Unit) {
    Column {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "profile icon",
            modifier = Modifier
                .padding(start = 320.dp, end = 2.dp, top = 5.dp)
                .size(50.dp)
                .clickable { function() }
        )
    }

}