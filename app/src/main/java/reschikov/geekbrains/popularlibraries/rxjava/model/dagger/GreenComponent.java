package reschikov.geekbrains.popularlibraries.rxjava.model.dagger;

import javax.inject.Singleton;
import dagger.Component;
import reschikov.geekbrains.popularlibraries.rxjava.model.Red;
import reschikov.geekbrains.popularlibraries.rxjava.model.White;

@Singleton
@Component(modules = {GreenModule.class})
public interface GreenComponent {
	void inject(Red red);
	void inject(White white);
}
