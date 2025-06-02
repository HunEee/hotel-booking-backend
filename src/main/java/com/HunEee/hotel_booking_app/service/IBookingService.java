package com.HunEee.hotel_booking_app.service;

import java.util.List;

import com.HunEee.hotel_booking_app.model.BookedRoom;

public interface IBookingService {
	
	List<BookedRoom> getAllBookingsByRoomId(Long roomId);

	List<BookedRoom> getAllBookings();

	BookedRoom findByBookingConfirmationCode(String confirmationCode);

	String saveBooking(Long roomId, BookedRoom bookingRequest);

	void cancelBooking(Long bookingId);

}
