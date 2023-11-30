package com.neuralfoundry.speechtotextapp

sealed class SpeechAppActions{
    object ToggleRecording: SpeechAppActions()
    object StartRecording: SpeechAppActions()
    object StopRecording: SpeechAppActions()
    object ClearTextArea: SpeechAppActions()
    data class UpdateRecognisedString(val newString: String?):SpeechAppActions()
}


