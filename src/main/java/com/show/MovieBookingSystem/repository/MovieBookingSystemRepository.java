package com.show.MovieBookingSystem.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.show.MovieBookingSystem.model.Booking;
import com.show.MovieBookingSystem.model.Movie;

@Repository
public interface MovieBookingSystemRepository {

		List<Movie> getAllMovies();
		Movie getMovieById(int movieId);
		void createBooking(Booking booking);

}