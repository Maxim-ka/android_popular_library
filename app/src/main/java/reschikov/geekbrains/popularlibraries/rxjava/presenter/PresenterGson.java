package reschikov.geekbrains.popularlibraries.rxjava.presenter;

import android.util.Log;

import com.google.gson.Gson;

import reschikov.geekbrains.popularlibraries.rxjava.model.JsonString;

public class PresenterGson {

	private String string = "{\"time_of_year\": \"summer\", \"year\": 2019}";

    public void start(){
	    JsonString jsonString = new JsonString();
	    jsonString.setTimeOfYear("summer");
	    jsonString.setYear(2019);
    	Gson gson = new Gson();
    	String strJson = gson.toJson(jsonString);
	    Log.i("jsonString", strJson);

	    JsonString str = gson.fromJson(string, JsonString.class);
	    Log.i("string", String.format("%s %d", str.getTimeOfYear(), str.getYear()));
	    JsonString string = gson.fromJson(strJson, JsonString.class);
	    Log.i("strJson", String.format("%s %d", string.getTimeOfYear(), string.getYear()));
    }
}
