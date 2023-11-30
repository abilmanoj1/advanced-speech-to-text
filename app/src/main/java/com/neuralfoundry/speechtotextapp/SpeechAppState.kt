package com.neuralfoundry.speechtotextapp

data class SpeechAppState(
    var isRecording: Boolean = false,
    var recognisedString: String? = ""
)
