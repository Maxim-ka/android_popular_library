package reschikov.geekbrains.popularlibraries.rxjava.presenter;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import reschikov.geekbrains.popularlibraries.rxjava.model.Generator;

public class PresenterTask3{

	private Observable<Integer> observable;
	private Disposable disposable;
	private Observable<Long> hotObservable;
	private Disposable hotDisposable;
	private Observable<Long> hotColdObservable;
	private Disposable hotColdDisposable;
	private Observable<String> coldObservable;
	private Disposable coldDisposable;

	public PresenterTask3() {
		Generator generator = new Generator();
		observable = generator.toGenerate();
		hotObservable = generator.toHotGenerate();
		hotColdObservable = generator.toHotColdGenerate();
		coldObservable = generator.toColdGenerate();
	}

	public void toRegister(){
		if (disposable != null) return;
		disposable = observable.observeOn(AndroidSchedulers.mainThread())
			.subscribe(integer -> Log.i("Task_3", "message " + integer),
				e -> Log.e("Task_3", e.getMessage()),
				() -> Log.i("Task_3", "end"));
		hotDisposable = hotObservable.observeOn(AndroidSchedulers.mainThread())
			.subscribe(integer -> Log.i("hot", "message " + integer),
				e -> Log.e("hot", e.getMessage()));
		hotColdDisposable = hotColdObservable.observeOn(AndroidSchedulers.mainThread())
			.subscribe(integer -> Log.i("hotCold", "message " + integer),
				e -> Log.e("hotCold", e.getMessage()));
		coldDisposable = coldObservable.observeOn(AndroidSchedulers.mainThread())
			.subscribe(string -> Log.i("cold", "message " + string),
				e -> Log.e("cold", e.getMessage()),
				() -> Log.i("cold", "end"));

	}

	public void unsubscribe() {
		if (disposable.isDisposed()) return;
		disposable.dispose();
		disposable = null;
		hotDisposable.dispose();
		hotDisposable = null;
		hotColdDisposable.dispose();
		hotColdDisposable = null;
		coldDisposable.dispose();
		coldDisposable = null;
	}
}
