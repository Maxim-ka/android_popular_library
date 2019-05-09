package reschikov.geekbrains.popularlibraries.rxjava.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import io.reactivex.Maybe;


@Dao
public interface UserDao {

	@Insert
	long insertUser(User user);

	@Insert
	long[] insertFew(User... users);

	@Delete
	void deleteUser(User user);

	@Update
	int updateUser(User user);

	@Query("SELECT * FROM table_users")
	Maybe<User[]> getAll();
}
