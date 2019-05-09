package reschikov.geekbrains.popularlibraries.rxjava.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import reschikov.geekbrains.popularlibraries.rxjava.model.App;
import reschikov.geekbrains.popularlibraries.rxjava.model.GeneratorUsers;
import reschikov.geekbrains.popularlibraries.rxjava.model.User;
import reschikov.geekbrains.popularlibraries.rxjava.model.UserDao;

public class PresenterRoom {

	private final List<User> userList = new ArrayList<>();
	private final UserDao userDao;
	private final GeneratorUsers generator;


	public PresenterRoom() {
		userDao = App.getDatabase().userDao();
		generator = new GeneratorUsers();
	}

	public void add(){
		final User user = generator.generateUser();
		Disposable disposable = addUser(user)
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(id -> {
				user.setId(id);
				Log.i("add", user.toString());
				userList.add(user);
				},
				e -> Log.e("add: ", e.getMessage()));
	}

	private Single<Long> addUser(User user){
		return Single.fromCallable(() -> userDao.insertUser(user)).subscribeOn(Schedulers.io());
	}

	public void addFew(){
		final User[] arrUsers = generator.generateFewUsers();
		Disposable disposable = addFewUsers(arrUsers)
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(rows -> {
					for (int i = 0; i < rows.length; i++) {
						arrUsers[i].setId(rows[i]);
						Log.i("addFew: ", String.valueOf(rows[i]));
						Log.i("addFewUser: ", String.valueOf(arrUsers[i]));
						userList.add(arrUsers[i]);
					}
				},
				e -> Log.e("addFew: ", e.getMessage()));
	}

	private Single<long[]> addFewUsers(User... users){
		return Single.fromCallable(() -> userDao.insertFew(users)).subscribeOn(Schedulers.io());
	}

	public void delete(){
		if (userList.isEmpty()) return;
		User user = userList.get(generator.choose(userList.size()));
		Disposable disposable = deleteUser(user)
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(() -> {
				Log.i("delete:", user.toString());
				userList.remove(user);
				},
				e -> Log.e("delete: ", e.getMessage()));
	}

	private Completable deleteUser(User user){
		return Completable.create(observer ->{
			try {
				userDao.deleteUser(user);
				Log.i("deleteUser:", user.toString());
				observer.onComplete();
			}catch (Exception e){
				observer.onError(e);
			}
		}).subscribeOn(Schedulers.io());
	}

	public void update(){
		if (userList.isEmpty()) return;
		int index = generator.choose(userList.size());
		User user = userList.get(index);
		Log.i("update_old", user.toString());
		user.setName(generator.generateString());
		user.setSurname(generator.generateString());
		user.setAge(generator.generateAge());
		Disposable disposable = updateUsers(user)
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(row -> {
				Log.i("update", String.valueOf(row));
				userList.set(index, user);
				Log.i("update_new", user.toString());
				},
				e -> Log.e("update: ", e.getMessage()));
	}

	private Single<Integer> updateUsers(User user){
		return Single.fromCallable(() -> userDao.updateUser(user)).subscribeOn(Schedulers.io());
	}

	public void check(){
		Disposable disposable = userDao.getAll()
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(users -> {
				if (!userList.isEmpty()) userList.clear();
				for (int i = 0; i < users.length; i++) {
					userList.add(users[i]);
					Log.i("check", users[i].toString());
				}
			},
			e -> Log.e("check", e.getMessage()),
			() -> Log.e("check", "завершено"));
	}
}
