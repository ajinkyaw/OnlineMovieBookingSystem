package com.show.MovieBookingSystem.model;

public class Movie {

	private int movieID;
	public String movieName;
	private float movieDuration;
	
	public Movie(int movieID,String movieName) {
		//super();
		this.movieID = movieID;
		this.movieName = movieName;
		//this.movieDuration = movieDuration;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public float getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(float movieDuration) {
		this.movieDuration = movieDuration;
	}

	@Override
	public String toString() {
		return "Movie [movieID=" + movieID + ", movieName=" + movieName + ", movieDuration=" + movieDuration + "]";
	}

}
