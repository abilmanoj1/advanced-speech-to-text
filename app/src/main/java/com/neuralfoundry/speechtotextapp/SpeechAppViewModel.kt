package com.neuralfoundry.speechtotextapp

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.JSONObject

class SpeechAppViewModel: ViewModel() {
    var state by mutableStateOf(SpeechAppState())
        private set

    private var outputString = ""
    private var tempString = ""

    private var partialText = ""
    private var text = ""

    private val handler = Handler(Looper.getMainLooper())
    private var partialTextEmpty = true

    //serves as a centralized handler for various actions triggered within the app
    fun onAction(action: SpeechAppActions){
        when(action){
            is SpeechAppActions.StartRecording -> startRecordAndConversion()
            is SpeechAppActions.StopRecording -> stopRecordingAndConversion()
            is SpeechAppActions.ClearTextArea -> clearTextAreaFunction()
            is SpeechAppActions.ToggleRecording -> toggleRecordingFunction()
            is SpeechAppActions.UpdateRecognisedString -> updateRecognisedString(action.newString)
        }
    }

    private fun startRecordAndConversion(){
        state = state.copy(isRecording = true)
    }

    private fun stopRecordingAndConversion(){
        state = state.copy(isRecording = false)
//        outputString = ""
//        text = ""
    }

    private fun clearTextAreaFunction(){
        Log.d("BUTTON CLICK","reached inside clear function")
        outputString = ""
        state = state.copy(recognisedString = outputString)
    }

    private fun toggleRecordingFunction(){
        if(state.isRecording){
            stopRecordingAndConversion()
        }
        else{
            startRecordAndConversion()
        }
    }

    // Function to update recognisedString in the state
     fun updateRecognisedString(newValue: String?) {
        val gson = Gson()

        try {
            val jsonObject = gson.fromJson(newValue, JsonObject::class.java)

            partialText = jsonObject["partial"]?.asString ?: ""
            text = jsonObject["text"]?.asString ?: ""

            if(!state.isRecording){
                if(text.lowercase() == "apple pie banana"){
                    startRecordAndConversion()
                }
            }
            else {
                if (partialText.isNotBlank()) {
                    // Choosing partial if present, otherwise text
                   outputString = "$tempString $partialText"

//                    outputString = if (text.isNotBlank()) text else partialText

                    partialTextEmpty = false
                    handler.removeCallbacksAndMessages(null)
                } else {
                    tempString = outputString
                    if (!partialTextEmpty && partialText.isBlank()) {
                        handler.postDelayed({
                            stopRecordingAndConversion()
                        }, 3000)
                    }
                }
            }


        } catch (e: Exception) {
            Log.e("Error parsing JSON", e.message ?: "Unknown error")
        }

        state = state.copy(recognisedString = outputString)
    }
}