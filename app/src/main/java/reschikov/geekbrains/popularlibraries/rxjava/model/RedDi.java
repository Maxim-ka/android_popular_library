package reschikov.geekbrains.popularlibraries.rxjava.model;

public class RedDi {

	private static Green green;

	public RedDi(Green green) {
		this.green = green;
		green.show(this);
	}
}
