package reschikov.geekbrains.popularlibraries.rxjava.model;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Derivable {
	@GET("/users/{user}")
	Single<Data.Avatar> getUrlImage(@Path("user") String user);
}
