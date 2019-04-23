package reschikov.geekbrains.popularlibraries.rxjava.model;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class Data extends Observable {

	private final LinkedList<Observer> observerList = new LinkedList<>();

	public LinkedList<Observer> getObserverList() {
		return observerList;
	}

	@Override
	public synchronized int countObservers() {
		return observerList.size();
	}

	@Override
	public synchronized void addObserver(Observer o) {
		observerList.add(o);
	}

	@Override
	public synchronized void deleteObserver(Observer o) {
		observerList.remove(o);
	}

	@Override
	public void notifyObservers(Object arg) {
		if (observerList.isEmpty()) return;
		for (int i = 0; i < observerList.size(); i++) {
			observerList.get(i).update(this, "message " + arg);
		}
	}
}
