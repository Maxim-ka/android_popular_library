package reschikov.geekbrains.popularlibraries.rxjava.model;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;

public class Generator {

	public Observable<Long> toHotGenerate(){
		ConnectableObservable<Long> observable = Observable.interval(1, TimeUnit.SECONDS, Schedulers.newThread())
			.publish();
		observable.connect();
		return observable;
	}

	public Observable<Long> toHotColdGenerate(){
		return Observable.interval(2, TimeUnit.SECONDS, Schedulers.newThread())
			.publish()
			.refCount();
	}

	public Observable<String> toColdGenerate(){
		return Observable.range(65, 26)
			.map(integer -> (char)integer.intValue())
			.map(String::valueOf)
			.doOnEach(string -> calculate())
			.subscribeOn(Schedulers.newThread());
	}


	public Observable<Integer> toGenerate(){
		return Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
			for (int i = 0; i < 50; i++) {
				calculate();
				if (emitter.isDisposed()) break;
				emitter.onNext(i);
			}
			emitter.onComplete();
		}).subscribeOn(Schedulers.computation());

	}

	private void calculate() {
		double r = 1;
		for (int j = 0; j < 50_000_000; j++)
			r = j * 0.01 + r / 0.01;
	}
}
