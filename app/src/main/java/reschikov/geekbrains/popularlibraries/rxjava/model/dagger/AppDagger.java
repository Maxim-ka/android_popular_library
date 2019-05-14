package reschikov.geekbrains.popularlibraries.rxjava.model.dagger;

import android.app.Application;

public class AppDagger extends Application {

	private static GreenComponent greenComponent;

	@Override
	public void onCreate() {
		super.onCreate();
		greenComponent = generateAppComponent();
	}

	public static GreenComponent getGreenComponent() {
		return greenComponent;
	}

	private GreenComponent generateAppComponent(){
		return DaggerGreenComponent
			.builder()
			.greenModule(new GreenModule())
			.build();
	}
}
