package reschikov.geekbrains.popularlibraries.rxjava.model;

import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application {

	private static AppDatabase database;

	public static AppDatabase getDatabase() {
		return database;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "MyUsers").build();
	}
}
