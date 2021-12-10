package com.coderbot.follower.presentation.common_views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.coderbot.follower.R
import com.coderbot.follower.ui.theme.PrimaryColor

@Composable
fun TopBar(title: String, backAction: () -> Unit)
{
    TopAppBar(
        title = { TextView(text = title, color = PrimaryColor) },
        navigationIcon = { Image(painterResource(id = R.drawable.ic_back), contentDescription = "", modifier = Modifier.size(36.dp).clickable { backAction() }) },
        elevation = 5.dp,
        backgroundColor = Color.White
    )
}