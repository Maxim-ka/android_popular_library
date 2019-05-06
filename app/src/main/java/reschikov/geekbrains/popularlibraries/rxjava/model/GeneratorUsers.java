package reschikov.geekbrains.popularlibraries.rxjava.model;

import android.util.Log;

import java.util.Random;

public class GeneratorUsers {

	private static final int MAX = 1071;
	private static final int MIN = 1040;
	private final Random random = new Random();

	public User generateUser(){
		String name = generateString();
		String surname = generateString();
		int age = generateAge();
		return new User(name, surname, age);
	}

	public int generateAge(){
		return random.nextInt(100) + 1;
	}

	public int choose(int number){
		return random.nextInt(number);
	}

	public User[] generateFewUsers(){
		User[] users = new User[random.nextInt(2) + 2];
		for (int i = 0; i <users.length ; i++) {
			users[i] = generateUser();
			Log.i("generateFewUsers", users[i].toString());
		}
		return users;
	}

	public String generateString(){
		int limit = random.nextInt(8) + 3;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < limit; i++) {
			builder.append((char) (MIN + (random.nextInt((MAX - MIN) + 1))));
		}
		return builder.toString();
	}
}
