package com.coderbot.follower.presentation.common_views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coderbot.follower.R
import com.coderbot.follower.ui.theme.PrimaryColor

@Composable
fun TextView(text: String, color: Color = PrimaryColor, size: Int = 16, isBold: Boolean = false) {
    Text(text = text,
        modifier = Modifier.padding(16.dp),
        color = color,
        fontSize = size.sp,
        fontWeight = if (isBold) FontWeight.W900 else FontWeight.W700,
        fontFamily = FontFamily(Font(R.font.comfortaa, FontWeight.Medium))
    )
}