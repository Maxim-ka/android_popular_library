package reschikov.geekbrains.popularlibraries.rxjava.model;

import javax.inject.Inject;

import reschikov.geekbrains.popularlibraries.rxjava.model.dagger.AppDagger;

public class Red {

	@Inject
	Green green;

	public Red() {
		AppDagger.getGreenComponent().inject(this);
		green.show(this);
	}
}
