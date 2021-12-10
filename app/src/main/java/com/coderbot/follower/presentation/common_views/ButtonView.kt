package com.coderbot.follower.presentation.common_views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.coderbot.follower.ui.theme.PrimaryColor
import com.coderbot.follower.utils.Constants

@Composable
fun ButtonView(label: String, width: ButtonWidth = ButtonWidth.MEDIUM, action: () -> Unit)
{
    when (width){
        ButtonWidth.WRAPPED -> {
            Button(modifier = Modifier.height(50.dp).wrapContentWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor, contentColor = Color.White),
                onClick = action) {
                Text(text = label)
            }
        }
        ButtonWidth.MEDIUM -> {
            Button(modifier = Modifier.height(50.dp).width(Constants.buttonWidth(LocalContext.current).dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor, contentColor = Color.White),
                onClick = action) {
                Text(text = label)
            }
        }
        ButtonWidth.FILLED -> {
            Button(modifier = Modifier.height(50.dp).fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor, contentColor = Color.White),
                onClick = action) {
                Text(text = label)
            }
        }
    }
}

enum class ButtonWidth{
    WRAPPED, FILLED, MEDIUM
}