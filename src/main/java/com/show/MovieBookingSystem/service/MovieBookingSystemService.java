package com.show.MovieBookingSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.show.MovieBookingSystem.model.Booking;
import com.show.MovieBookingSystem.model.Movie;

@Service
public interface MovieBookingSystemService {

	List<Movie> getAllMovies();
	Movie getMovieById(int movieId);
	void createBooking(Booking booking);

}