package com.neuralfoundry.speechtotextapp

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

val customFontFamily = FontFamily(
    Font(R.font.titilliumweb_semibold, FontWeight.SemiBold), // Replace with the name of your font file (without extension)
    Font(R.font.titilliumweb_bold, FontWeight.Bold),
    Font(R.font.titilliumweb_regular,FontWeight.Normal),
    Font(R.font.titilliumweb_light)
    // Add other font styles if available (italic, etc.)
)