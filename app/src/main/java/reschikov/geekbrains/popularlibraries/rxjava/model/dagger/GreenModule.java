package reschikov.geekbrains.popularlibraries.rxjava.model.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import reschikov.geekbrains.popularlibraries.rxjava.model.Green;

@Module
public class GreenModule {

	@Singleton
	@Provides
	public Green provideGreen(){
		return new Green();
	}
}
