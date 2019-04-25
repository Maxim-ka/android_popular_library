package reschikov.geekbrains.popularlibraries.rxjava.presenter;

import android.util.Log;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import reschikov.geekbrains.popularlibraries.rxjava.model.Generator;

public class PresenterTask1 {

	private Single<Long> error = new Generator().toMessageError();
	private Single<String> single = new Generator().toMessage();

	public void start(){
        error.observeOn(AndroidSchedulers.mainThread())
	        .subscribe(number -> Log.i("error", "message " + number),
		        error -> Log.e("error", error.getMessage()));
		single.observeOn(AndroidSchedulers.mainThread())
			.subscribe(string -> Log.i("single", "message " + string),
				error -> Log.e("single", error.getMessage()));
    }
}
