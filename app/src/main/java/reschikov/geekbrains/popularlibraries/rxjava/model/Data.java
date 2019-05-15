package reschikov.geekbrains.popularlibraries.rxjava.model;
import com.google.gson.annotations.SerializedName;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Data {

	public class Avatar{
		@SerializedName("avatar_url")
		private String url;

		public void setUrl(String url) {
			this.url = url;
		}

		public String getUrl() {
			return url;
		}
	}

	private Derivable derivable;

	public Data() {
		derivable = new Retrofit.Builder()
			.baseUrl("https://api.github.com")
			.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			.addConverterFactory(GsonConverterFactory.create())
			.build()
		    .create(Derivable.class);
	}

	public Single<Avatar> toRequest(){
		return (derivable.getUrlImage("JakeWharton")).subscribeOn(Schedulers.io());
	}
}
