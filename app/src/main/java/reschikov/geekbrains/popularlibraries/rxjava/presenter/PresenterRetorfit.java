package reschikov.geekbrains.popularlibraries.rxjava.presenter;

import android.util.Log;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import reschikov.geekbrains.popularlibraries.rxjava.model.Data;

public class PresenterRetorfit {

	private String response;

	public String toRequest(){
		Single<Data.Avatar> request = new Data().toRequest();
		Disposable disposable = request.observeOn(AndroidSchedulers.mainThread())
			.subscribe(avatar -> response = avatar.getUrl(),
			e -> Log.e("ServerError", e.getMessage()));
		return response;
	}
}
