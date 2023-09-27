package com.show.MovieBookingSystem.service;

 

import java.util.*;

 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

 

 

import com.show.MovieBookingSystem.model.Booking;

import com.show.MovieBookingSystem.model.Movie;

import com.show.MovieBookingSystem.repository.MovieBookingSystemRepository;

 

@Service("MovieBookingSystemService")

public class MovieBookingSystemServiceImpl implements MovieBookingSystemService {

 

	@Autowired MovieBookingSystemRepository MovieBookingSystemRepository;

	@Override

	public List<Movie> getAllMovies() {

		 return MovieBookingSystemRepository.getAllMovies();

	}

 

	@Override

	public Movie getMovieById(int movieId) {

		return MovieBookingSystemRepository.getMovieById(movieId);

	}



	@Override
	public void createBooking(Booking booking) {
		// TODO Auto-generated method stub
		
	}



}