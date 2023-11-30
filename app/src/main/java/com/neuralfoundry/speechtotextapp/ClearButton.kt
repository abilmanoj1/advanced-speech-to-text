package com.neuralfoundry.speechtotextapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neuralfoundry.speechtotextapp.ui.theme.CustomRed
import com.neuralfoundry.speechtotextapp.ui.theme.CustomWhite


@Composable
fun ClearButton(state: SpeechAppState, onClick: () -> Unit){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 370.dp,start = 245.dp)
//            .clickable {onClick()}
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .width(100.dp)
                .height(40.dp), // Increase the height of the button
//                .padding(horizontal = 0.5.dp, vertical = 0.5.dp), // Adjust padding
            colors = ButtonDefaults.buttonColors(containerColor = CustomRed)
        ) {
            Text(text = "X Clear",color = CustomWhite, fontSize = 15.sp, fontFamily = customFontFamily, fontWeight = FontWeight.Bold)
        }
    }
}