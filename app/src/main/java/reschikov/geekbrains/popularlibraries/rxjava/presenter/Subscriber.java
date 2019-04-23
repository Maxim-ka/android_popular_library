package reschikov.geekbrains.popularlibraries.rxjava.presenter;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

public class Subscriber implements Observer {

	private static int counter;
	private int number;

	Subscriber() {
		number = ++counter;
	}

	@Override
	public void update(Observable o, Object arg) {
		Log.i("subscriber_" + number, String.format("%s, current thread %s", arg, Thread.currentThread().getName()));
	}
}
