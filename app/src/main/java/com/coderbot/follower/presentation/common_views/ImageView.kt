package com.coderbot.follower.presentation.common_views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun ImageView(painter: Painter)
{
    Image(painter = painter, contentDescription = "", modifier = Modifier.padding(16.dp))
}