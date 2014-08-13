package com.UnityNativeToolsAndroid;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;


public class Speech {
	static TextToSpeech tts;
	
	public static void SayText(Context context, final String text)
	{
		Log.i("UnityNativeToolsAndroid", "Context is " + ((context == null) ? "null" : "not null"));
		
		tts = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
			   @Override
			   public void onInit(int status) {
					Log.i("UnityNativeToolsAndroid", "TTS init status " + status);
					
					if(status == TextToSpeech.ERROR)
					{
						Log.i("UnityNativeToolsAndroid", "TextToSpeech init failed with error");
					}else{
						tts.setLanguage(Locale.ENGLISH);
						tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
					}
			   }
			}
		);
	}
}
