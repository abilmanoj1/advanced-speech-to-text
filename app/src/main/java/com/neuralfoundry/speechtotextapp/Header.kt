package com.neuralfoundry.speechtotextapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neuralfoundry.speechtotextapp.ui.theme.DarkYellow
import com.neuralfoundry.speechtotextapp.ui.theme.LightGray


@Composable
fun Header(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(DarkYellow)
    ) {
        Text(
            text = title,
            color = LightGray,
//            style = MaterialTheme.typography.h6,
            modifier = Modifier.align(Alignment.Center),
            fontSize = 24.sp,
            fontFamily = customFontFamily,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun HeaderPreview() {
    Header(title = "Speech to Text")
}