package reschikov.geekbrains.popularlibraries.rxjava.presenter;

import android.util.Log;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import reschikov.geekbrains.popularlibraries.rxjava.model.Data;

public class PresenterRetorfit {

	public interface  Loadable{
		void download(String url);
	}

	private Loadable loadable;

	public PresenterRetorfit(Loadable loadable) {
		this.loadable = loadable;
	}

	public void toRequest(){
		Single<Data.Avatar> request = new Data().toRequest();
		Disposable disposable = request.observeOn(AndroidSchedulers.mainThread())
			.subscribe(avatar -> loadable.download(avatar.getUrl()),
			e -> Log.e("ServerError", e.getMessage()));
	}
}
