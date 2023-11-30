package com.neuralfoundry.speechtotextapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.vosk.android.RecognitionListener


@Composable
fun VoiceToText() {
    Row(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.padding(10.dp)){
            Text(
                text = "What's on your mind?",
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 20.dp),
                fontFamily = customFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 30.sp,
                color = Color.White,
                maxLines = 2
            )
        }
    }
}

//(interfaceImplementation: RecognitionListener
//@Preview(showBackground = true)
//@Composable
//fun VoiceToTextPreview() {
//    VoiceToText(interfaceImplementation: RecognitionListener)
//}