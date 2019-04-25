package reschikov.geekbrains.popularlibraries.rxjava.presenter;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import reschikov.geekbrains.popularlibraries.rxjava.model.Generator;

public class PresenterTask3{

	private Observable<String> observable;
	private Disposable disposable;

	public PresenterTask3() {
		Generator generator = new Generator();
		observable = generator.toCombine();
	}

	public void toRegister(){
		if (disposable != null) return;
		disposable = observable.observeOn(AndroidSchedulers.mainThread())
			.subscribe(string -> Log.i("Task_1", "message " + string),
				e -> Log.e("Task_1", e.getMessage()),
				() -> Log.i("Task_1", "end"));
	}

	public void unsubscribe() {
		if (disposable == null || disposable.isDisposed()) return;
		disposable.dispose();
		disposable = null;
	}
}
