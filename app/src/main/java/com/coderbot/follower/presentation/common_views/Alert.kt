package com.coderbot.follower.presentation.common_views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.coderbot.follower.R

@Composable
fun Alert(message: String, icon: Int, action: () -> Unit = { })
{
    val showDialog = remember { mutableStateOf(true) }

    if (showDialog.value)
    {
        Dialog(
            onDismissRequest = {},
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
            ),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(CornerSize(15.dp))
                    )
                    .padding(20.dp)
            ) {
                Image(painterResource(id = icon), contentDescription = "", modifier = Modifier.size(36.dp))
                Box(modifier = Modifier.height(24.dp))
                TextView(text = message)
                Box(modifier = Modifier.height(24.dp))
                ButtonView(label = stringResource(id = R.string.ok), width = ButtonWidth.WRAPPED, action = {
                    showDialog.value = false
                    action()
                })
            }
        }
    }
}