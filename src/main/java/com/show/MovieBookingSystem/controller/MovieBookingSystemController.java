package com.show.MovieBookingSystem.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

import com.show.MovieBookingSystem.model.Admin;
import com.show.MovieBookingSystem.model.Booking;
import com.show.MovieBookingSystem.model.Date;
import com.show.MovieBookingSystem.model.Movie;
import com.show.MovieBookingSystem.model.MovieScheduler;
import com.show.MovieBookingSystem.model.Time;
import com.show.MovieBookingSystem.model.User;
import com.show.MovieBookingSystem.service.JDBCService;
import com.show.MovieBookingSystem.service.MovieBookingSystemService;

@Controller

@ResponseBody

@RequestMapping

public class MovieBookingSystemController {

	@Autowired

	private JDBCService jdbcService;

	@Autowired

	MovieBookingSystemService bookingService;

	@GetMapping("/dashboard")

	public ModelAndView dashboard(ModelAndView model) {

		String message = "Welcome to our Movie Booking System!";

		model.addObject("message", message);

		model.setViewName("dashboard");

		return model; 

	}

	@PostMapping("/login")

	public ModelAndView showRegistrationForm(ModelAndView model) {

		model.setViewName("login");

		return model;

	}

	@PostMapping("/login-api")

	public ModelAndView registerUser(

			@RequestParam("name") String name,

			@RequestParam("phoneNo") String phoneNo,

			ModelAndView model) {

		User user = new User(name, phoneNo);
		int userId = jdbcService.addingNewUser(user);

		String respo = "";

		respo = " Login Successful ";
		model.addObject("message", respo);
		model.addObject("userId", userId);
		model.setViewName("afterlogin");
		return model;

	}

	@GetMapping("/adminlogin")
	public ModelAndView showadminloginform(ModelAndView model) {

		model.setViewName("admin");
		return model;

	}

	@PostMapping("/adminlogin-api")

	public ModelAndView registerAdmin(@RequestParam("adminName") String adminName,
			@RequestParam("password") String password, ModelAndView model) {
		Admin admin = new Admin(adminName, password);

		if (admin.getAdminName() == "rozina" && admin.getPassword() == "1234") {
			String message = "Admin Valid";
			model.addObject("message", message);
			model.setViewName("afteradminlogin");

		} else {
			model.setViewName("bad");

		}
		return model;
	}

	@PostMapping("/editschd")
	public ModelAndView editSchd(ModelAndView model) {
		ArrayList<MovieScheduler> schdlist = jdbcService.showSchedule();
		//System.out.println(schdlist.toString());

		model.addObject("schdlist", schdlist);
		model.setViewName("editschedule");

		return model;

	}

	@PostMapping("/replace")
	public ModelAndView editevents(@RequestParam("eventId") int eventId, ModelAndView model) {
		//System.out.println(eventId);
		model.addObject("eventId", eventId);
		model.setViewName("replace");
		return model;
	}

	@PostMapping("/replace-api")
	public ModelAndView editeventsaction(@RequestParam("eventId") int eventId, @RequestParam("date") String date,
			@RequestParam("time") String time, ModelAndView model) {
		//System.out.println("hi from replace api envent id is " + eventId);
		jdbcService.updateSchedule(eventId, date, time);
		ArrayList<MovieScheduler> schdlist = jdbcService.showSchedule();
		model.addObject("schdlist", schdlist);
		model.setViewName("editschedule");

		return model;
	}

	@PostMapping("/removingEvent")
	public ModelAndView removeEvents(@RequestParam("eventId") int eventId, ModelAndView model) {
		//System.out.println(eventId);
		jdbcService.deleteSchedule(eventId);
		ArrayList<MovieScheduler> schdlist = jdbcService.showSchedule();
		model.addObject("eventId", eventId);
		model.addObject("schdlist", schdlist);
		model.setViewName("editschedule");

		return model;
	}

	@PostMapping("/addSchd")

	public ModelAndView addSchd(ModelAndView model)

	{

		ArrayList<Movie> movielist = jdbcService.getMovieForScheduler();

		//System.out.println(movielist.toString());

		model.addObject("movielist", movielist);

		model.setViewName("movieforschd");

		return model;

	}

	@PostMapping("/addSchd-api")

	public ModelAndView addSchdAction(@RequestParam("movieId") int movieId, ModelAndView model)

	{

		System.out.println("hi from addSchd api movie id is " + movieId);

		model.addObject("movieId", movieId);

		model.setViewName("addrecord");

		return model;

	}

	@PostMapping("/schdtoDB")

	public ModelAndView schdtoDataBase(@RequestParam("movieId") int movieId, @RequestParam("date") String date,
			@RequestParam("time") String time, ModelAndView model) {

		MovieScheduler movieScheduler = new MovieScheduler(movieId, date, time);

		jdbcService.addSchedule(movieScheduler);

		ArrayList<MovieScheduler> schdlist = jdbcService.showSchedule();

		model.addObject("schdlist", schdlist);

		model.setViewName("editschedule");

		return model;

	}



	@GetMapping("/getDate")
	public ModelAndView getDate(@RequestParam("userId") int userId, ModelAndView model) {
		// String str= "userId";
		System.out.println("hii from /getdate " + userId);
		ArrayList<Date> datelist = jdbcService.getDate();
		// Object session;
		// session.setAttribute("userId",userId);
		model.addObject("userId", userId);
		model.addObject("datelist", datelist);
		model.setViewName("getdate");
		return model;

	}

	@PostMapping("/getDate-api")
	public ModelAndView getDateApi(@RequestParam("userId") int userId, @RequestParam("date") String date,
			ModelAndView model) {
		ArrayList<Movie> movielist = jdbcService.getMovie(date);
		//System.out.println(movielist.toString());
		model.addObject("userId", userId);
		model.addObject("movielist", movielist);
		model.setViewName("movie");
		return model;
	}

	@PostMapping("/showTimings")
	public ModelAndView ShowTimings(@RequestParam("userId") int userId, @RequestParam("movieId") int movieId,
			ModelAndView model) {
		//System.out.println("hii from /showTimings userId" + userId);
		ArrayList<Time> timelist = jdbcService.getTime(movieId);
		//System.out.println(timelist.toString());
		model.addObject("userId", userId);
		model.addObject("movieId", movieId);
		model.addObject("timelist", timelist);
		model.setViewName("time");
		return model;
	}

	@PostMapping("/booking")
	public ModelAndView bookMovieApi(@RequestParam("time") String time, @RequestParam("movieId") int movieId,
			@RequestParam("userId") int userId, ModelAndView model) {

		//System.out.println("hii from /booking time" + time + " user " + userId + " movieid " + movieId);

		// Booking booking = new Booking(eventId, userId);
		int result = jdbcService.addBooking(time, movieId, userId);

		if (result > 0) {
			model.setViewName("paymentt");
		} else {
			String message = "bad";

			model.addObject("message", message);
			model.setViewName("bad");
		}
		return model;
	}


	@GetMapping("/makePaymentPage") // Change @RequestMapping to @GetMapping
	public ModelAndView showPaymentPage(ModelAndView model) {
		model.setViewName("paymentt");
		return model;

	}

	@PostMapping("/makePayment")
	public ModelAndView makePayment(@RequestParam("upiId") String upiId, ModelAndView model) {
		String message = "Payment failed. Invalid UPI ID.";

		// Check if UPI ID contains "@ok" to consider it valid
		if (upiId.contains("@ok")) {
			// In a real system, you would implement payment processing logic here
			message = "Payment done successfully.";
		} else {
			message = "Payment Failed.";
		}

		model.addObject("message", message);
		model.setViewName("paymentt");
		return model;
	}

}