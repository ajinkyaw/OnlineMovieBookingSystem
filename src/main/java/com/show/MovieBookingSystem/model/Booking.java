package com.show.MovieBookingSystem.model;

public class Booking {

	int bookingId;
	int eventId;
	int userId;

	
	public Booking(int eventId, int userId) {
		super();
		this.eventId = eventId;
		this.userId = userId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", movieId=" + eventId + ", userId=" + userId + "]";
	}

	
}
