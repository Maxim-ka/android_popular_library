package reschikov.geekbrains.popularlibraries.rxjava.model;

import javax.inject.Inject;

import reschikov.geekbrains.popularlibraries.rxjava.model.dagger.AppDagger;

public class White {

	@Inject
	Green green;

	public White() {
		AppDagger.getInstance().getGreenComponent().inject(this);
		green.show(this);
	}
}
