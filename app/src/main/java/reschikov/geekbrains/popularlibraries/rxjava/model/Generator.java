package reschikov.geekbrains.popularlibraries.rxjava.model;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;

public class Generator{

	private Observable<Long> toHotGenerate(){
		ConnectableObservable<Long> observable = Observable.interval(1, TimeUnit.SECONDS, Schedulers.newThread())
			.publish();
		observable.connect();
		return observable;
	}

	private Observable<Long> toHotColdGenerate(){
		return Observable.interval(2, TimeUnit.SECONDS, Schedulers.newThread())
			.publish()
			.refCount();
	}

	private Observable<String> toColdGenerate(){
		return Observable.range(65, 26)
			.map(integer -> (char)integer.intValue())
			.map(String::valueOf)
			.doOnEach(string -> calculate())
			.subscribeOn(Schedulers.newThread());
	}


	private Observable<Integer> toGenerate(){
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
		for (int j = 0; j < 20_000_000; j++)
			r = j * 0.01 + r / 0.01;
	}

	public Observable<String> toCombine(){
		return Observable.zip(toHotGenerate(), toHotColdGenerate(), toColdGenerate(), toGenerate(),
			(hotLong, hotColdLong, coldString, toInt) -> String.format(Locale.getDefault(),"%d, %d, %s, %d", hotLong, hotColdLong, coldString, toInt))
			.subscribeOn(Schedulers.computation());
	}

	public Single<Long> toMessageError(){
		return Single.fromObservable(toHotGenerate())
			.subscribeOn(Schedulers.newThread());
	}

	public Single<String> toMessage(){
		return Single.just("все ок")
			.subscribeOn(Schedulers.newThread());
	}
}
