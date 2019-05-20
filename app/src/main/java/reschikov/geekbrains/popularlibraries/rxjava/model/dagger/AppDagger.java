package reschikov.geekbrains.popularlibraries.rxjava.model.dagger;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class AppDagger extends Application {

	private static AppDagger instance;
	private GreenComponent greenComponent;
	private RefWatcher watcher;

	public static AppDagger getInstance() {
		return instance;
	}

	public GreenComponent getGreenComponent() {
		return greenComponent;
	}

	public RefWatcher getWatcher() {
		return watcher;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		if (!LeakCanary.isInAnalyzerProcess(this)) watcher = LeakCanary.install(this);
		instance = this;
		greenComponent = generateAppComponent();
	}

	private GreenComponent generateAppComponent(){
		return DaggerGreenComponent
			.builder()
			.greenModule(new GreenModule())
			.build();
	}
}
