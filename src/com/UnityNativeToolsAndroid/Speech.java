package com.UnityNativeToolsAndroid;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;

import java.util.Locale;


public class Speech implements OnInitListener {
	public TextToSpeech tts;
	public Context context;
	public boolean isTtsReady; 
	
	private static final String TAG = "UnityNativeToolsAndroid";
	
	public Speech(Context context)
	{
		this.setContext(context);
		
		tts = new TextToSpeech(this.getContext(), this);
	}
	
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		Log.i(TAG, "Context is " + ((context == null) ? "null" : "not null"));
		
		this.context = context;
	}

	public boolean speak(final String text)
	{
		if(isTtsReady){
			tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
			
			return true;
		}
		
		Log.e(TAG, "Can not call speak method, because TTS is not ready.");
		
		return false;
	}

	@Override
	public void onInit(int status) {
		Log.i(TAG, "TTS init status " + status);
		
		if(status == TextToSpeech.ERROR)
		{
			Log.e(TAG, "TextToSpeech init failed with error");
			
			isTtsReady = false;
		}else{
			tts.setLanguage(Locale.ENGLISH);
			
			isTtsReady = true;
		}
	}
}
