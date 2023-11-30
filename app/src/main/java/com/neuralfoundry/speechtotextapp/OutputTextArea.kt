package com.neuralfoundry.speechtotextapp

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OutputTextArea(state: SpeechAppState,onClearClicked: () -> Unit)
{
    Row(modifier = Modifier.fillMaxSize().padding(
        horizontal = 5.dp
    )) {
        Box(modifier = Modifier.padding(start = 10.dp, top = 100.dp, end = 10.dp, bottom = 10.dp).border(
            width = 1.5.dp, // Border width
            color = Color.White, // Border color
            shape = RoundedCornerShape(8.dp), // Border radius
        )){
            Text(
                text = if (state.recognisedString.isNullOrBlank()) {
                    "The text from the speech model comes here....."
                } else {
                    state.recognisedString.toString()
                },
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp).height(400.dp),
                fontFamily = customFontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 15.sp,
                color = Color.White,
                maxLines = 100
            )
            if (!state.recognisedString.isNullOrBlank()) {
                ClearButton(state = state, onClick = onClearClicked)
            }
        }
    }
}

