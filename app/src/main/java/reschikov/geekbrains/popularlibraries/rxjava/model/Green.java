package reschikov.geekbrains.popularlibraries.rxjava.model;

import android.util.Log;

public class Green {

	void show(Object object){
		Log.i(object.getClass().getSimpleName() + " -> show: ", getClass().getSimpleName() + hashCode());
	}

	public int add(int x, int y){
		return x + y;
	}
}





