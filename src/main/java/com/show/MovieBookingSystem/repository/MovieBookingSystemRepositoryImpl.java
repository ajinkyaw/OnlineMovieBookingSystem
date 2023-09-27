package com.show.MovieBookingSystem.repository;

 

import java.util.*;

import java.util.List;

 

import org.springframework.stereotype.Repository;

 

 

import com.show.MovieBookingSystem.model.Booking;

import com.show.MovieBookingSystem.model.Movie;

 

@Repository("MovieBookingSystemRepository")

public class MovieBookingSystemRepositoryImpl implements MovieBookingSystemRepository {

 

	List<Movie> movieList;

	List<Booking> bookingList;

	

//	{
//		movieList = new ArrayList<Movie>();
//
//		movieList.add(new Movie(1,"movie1",3));
//
//		movieList.add(new Movie(2,"movie2",3));
//
//		movieList.add(new Movie(3,"movie3",3));
//
//		movieList.add(new Movie(4,"movie4",3));
//
//		bookingList = new ArrayList<Booking>();
//	}

	@Override

	public List<Movie> getAllMovies() {

		 return movieList ;

	}

 

	@Override

	public Movie getMovieById(int movieId) {

		return movieList.get(0);

	}

 

	@Override

	public void createBooking(Booking booking) {

		bookingList.add(booking);

	}

 

}

 