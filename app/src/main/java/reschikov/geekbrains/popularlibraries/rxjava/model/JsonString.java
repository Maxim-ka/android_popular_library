package reschikov.geekbrains.popularlibraries.rxjava.model;

import com.google.gson.annotations.SerializedName;

public class JsonString {

	@SerializedName("time_of_year")
	private String timeOfYear;

	@SerializedName("year")
	private int year;

	public String getTimeOfYear() {
		return timeOfYear;
	}

	public void setTimeOfYear(String timeOfYear) {
		this.timeOfYear = timeOfYear;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
