package reschikov.geekbrains.popularlibraries.rxjava.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Locale;

@Entity(tableName = "table_users")
public class User {

	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	private long id;

	@ColumnInfo(name = "name")
	private String name;

	@ColumnInfo(name = "surname")
	private String surname;

	@ColumnInfo(name = "age")
	private int age;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	User(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	@NonNull
	@Override
	public String toString() {
		return String.format(Locale.getDefault(),"%d, %s, %s, %d", id, name, surname, age);
	}
}
