package com.coderbot.follower.presentation.common_views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.coderbot.follower.ui.theme.PrimaryColor

@Composable
fun ExtendedFAB(label: String, icon: Int, action: () -> Unit)
{
    ExtendedFloatingActionButton(
        text = { TextView(text = label) },
        contentColor = PrimaryColor,
        backgroundColor = Color.White,
        onClick = action,
        icon = { Image(painterResource(id = icon), contentDescription = "", modifier = Modifier.size(36.dp)) }
    )
}