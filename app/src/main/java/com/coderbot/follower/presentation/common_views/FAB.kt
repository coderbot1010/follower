package com.coderbot.follower.presentation.common_views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.coderbot.follower.ui.theme.PrimaryColor

@Composable
fun FAB(icon: Int, action: () -> Unit)
{
    FloatingActionButton(
        onClick = action,
        contentColor = PrimaryColor,
        backgroundColor = Color.White
    ) {
        Image(painterResource(id = icon), contentDescription = "", modifier = Modifier.size(36.dp))
    }
}