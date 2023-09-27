package com.show.MovieBookingSystem.model;

public class MovieScheduler {

	private int eventId;
	private int movieId;
	private String date;
	private String time;

	public MovieScheduler(int eventId, int movieId, String date, String time) {

		this.eventId = eventId;
		this.movieId = movieId;
		this.date = date;
		this.time = time;
	}

	public MovieScheduler(int movieId, String date, String time) {
		super();
		this.movieId = movieId;
		this.date = date;
		this.time = time;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "MovieScheduler [eventId=" + eventId + ", movieId=" + movieId + ", date=" + date + ", time=" + time
				+ "]";
	}

}
