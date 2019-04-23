package reschikov.geekbrains.popularlibraries.rxjava.presenter;

import reschikov.geekbrains.popularlibraries.rxjava.model.Data;

public class PresenterTask2{

	private int counter;
	private Data data;

	public PresenterTask2() {
		data = new Data();
	}

	public void subscribe(){
		data.addObserver(new Subscriber());
	}

	public void unsubscribe() {
		if (data.countObservers() == 0) return;
		data.deleteObserver(data.getObserverList().getFirst());
	}

	public void toSpam(){
		data.notifyObservers(counter++);
	}
}
