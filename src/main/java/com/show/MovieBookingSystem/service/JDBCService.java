package com.show.MovieBookingSystem.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import com.show.MovieBookingSystem.model.Booking;
import com.show.MovieBookingSystem.model.Date;
import com.show.MovieBookingSystem.model.Movie;
import com.show.MovieBookingSystem.model.MovieScheduler;
import com.show.MovieBookingSystem.model.Time;
import com.show.MovieBookingSystem.model.User;
import com.show.MovieBookingSystem.util.JDBCUtil;

@Service
public class JDBCService {

	public int addingNewUser(User user) {

		int userId = user.getUserId();
		String phoneNo = user.getPhoneNo();
		int rowsAffected = 0;
		try {

			Connection connection = JDBCUtil.getConnection();

			String sqlInsert = "INSERT INTO userdata (name, phoneNo) VALUES (?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPhoneNo());

			rowsAffected = preparedStatement.executeUpdate();

			System.out.println("Rows affected: " + rowsAffected);

			connection.close();

		} catch (SQLIntegrityConstraintViolationException e) {
			// System.out.println("Catch exception"+userId+" "+ phoneNo);

			userId = getExistingUserId(phoneNo);
			user.setUserId(userId);
			System.out.println("existing user id & phoneNumber" + userId + " " + phoneNo);
			return userId;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected = getExistingUserId(phoneNo);

	}

	public int getExistingUserId(String phoneNumber) {

		int userId = 0;
		try {

			Connection connection = JDBCUtil.getConnection();

			String sqlInsert = "SELECT userId FROM userdata WHERE phoneNo = " + "'" + phoneNumber + "'";

			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			userId = resultSet.getInt("userId");
			System.out.println("....." + userId);
			connection.close();

		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Catch exception");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;

	}

	public int addBooking(String time, int movieId, int userId) {

		Booking booking;
		int rowsAffected = 0;
		try {

			Connection connection = JDBCUtil.getConnection();

			String sqlSelect = "SELECT eventId FROM moviescheduler WHERE time=" + "'" + time + "'" + " and movieId="
					+ "'" + movieId + "'";

			PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();
			int eventId = resultSet.getInt("eventId");

			booking = new Booking(eventId, userId);

			String sqlInsert = "INSERT INTO bookingdata (eventId, userId) VALUES (?,?)";

			PreparedStatement preparedStatement2 = connection.prepareStatement(sqlInsert);

			preparedStatement2.setInt(1, booking.getEventId());
			preparedStatement2.setInt(2, booking.getUserId());

			rowsAffected = preparedStatement2.executeUpdate();

			System.out.println("Rows affected: " + rowsAffected);

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;

	}

	public ArrayList<Date> getDate() {
		ArrayList<Date> datelist = new ArrayList<>();
		try {

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT DISTINCT date FROM moviescheduler");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				String temp = resultSet.getString("date");
				datelist.add(new Date(temp));
			}

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datelist;

	}

	public ArrayList<Movie> getMovie(String date) {
		ArrayList<Movie> moviesList = new ArrayList<>();

		try {
			Connection connection = JDBCUtil.getConnection();

			String str = "SELECT DISTINCT moviescheduler.movieId , moviedata.movieName " + " FROM moviescheduler "
					+ " INNER JOIN moviedata ON moviescheduler.movieId = moviedata.movieId "
					+ " WHERE moviescheduler.date = " + "'" + date + "'";

			PreparedStatement preparedStatement = connection.prepareStatement(str);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int movieId = resultSet.getInt("movieId");
				String movieName = resultSet.getString("movieName");

				Movie movie = new Movie(movieId, movieName);
				moviesList.add(movie);

			}

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return moviesList;
	}

	public ArrayList<Time> getTime(int movieId) {

		ArrayList<Time> timelist = new ArrayList<>();

		try {

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT DISTINCT time FROM moviescheduler WHERE moviescheduler.movieId = " + "'" + movieId + "'");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				String temp = resultSet.getString("time");

				timelist.add(new Time(temp));

			}

			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return timelist;

	}

	public ArrayList<MovieScheduler> showSchedule() {

		MovieScheduler movieScheduler = null;

		ArrayList<MovieScheduler> schedulerList = new ArrayList<>();

		try {

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM moviescheduler");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int eventId = resultSet.getInt("eventId");

				int movieId = resultSet.getInt("movieId");

				String date = resultSet.getString("date");

				String time = resultSet.getString("time");

				movieScheduler = new MovieScheduler(eventId, movieId, date, time);

				schedulerList.add(movieScheduler);

			}

			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return schedulerList;

	}

	public void updateSchedule(int eventId, String date, String time) {

		try {

			Connection connection = JDBCUtil.getConnection();

			String sqlUpdate = "UPDATE moviescheduler SET  moviescheduler.date = ? WHERE moviescheduler.eventId = "
					+ "'" + eventId + "'";

			PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);

			preparedStatement.setString(1, date);
			preparedStatement.executeUpdate();

			String sqlUpdate1 = "UPDATE moviescheduler SET  moviescheduler.time = ? WHERE moviescheduler.eventId = "
					+ "'" + eventId + "'";

			PreparedStatement preparedStatement1 = connection.prepareStatement(sqlUpdate1);

			preparedStatement1.setString(1, time);

			preparedStatement1.executeUpdate();

			connection.close();

		} catch (SQLIntegrityConstraintViolationException e) {

			System.out.println("Catch exception");

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	public void deleteSchedule(int eventID) {

		// int eventId = movieScheduler.getEventId();
		int eventId = eventID;

		try {

			Connection connection = JDBCUtil.getConnection();

			String sqlDelete = "DELETE FROM moviescheduler WHERE moviescheduler.eventId = " + "'" + eventId + "'";

			PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);

			preparedStatement.executeUpdate();

			connection.close();

		} catch (SQLIntegrityConstraintViolationException e) {

			System.out.println("Catch exception");

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	/////////////////////////////////
	public ArrayList<Movie> getMovieForScheduler() {
		ArrayList<Movie> moviesList = new ArrayList<>();

		try {
			Connection connection = JDBCUtil.getConnection();

			String str = "SELECT * FROM moviedata";

			PreparedStatement preparedStatement = connection.prepareStatement(str);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int movieId = resultSet.getInt("movieId");
				String movieName = resultSet.getString("movieName");

				Movie movie = new Movie(movieId, movieName);
				moviesList.add(movie);

			}

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return moviesList;
	}

	public void addSchedule(MovieScheduler movieScheduler) {

		try {

			Connection connection = JDBCUtil.getConnection();

			String sqlInsert = "INSERT INTO moviescheduler (movieId, date, time) VALUES (?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

			preparedStatement.setInt(1, movieScheduler.getMovieId());

			preparedStatement.setString(2, movieScheduler.getDate());

			preparedStatement.setString(3, movieScheduler.getTime());

			preparedStatement.executeUpdate();

			connection.close();

		} catch (SQLIntegrityConstraintViolationException e) {

			System.out.println("Catch exception");

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}
}
