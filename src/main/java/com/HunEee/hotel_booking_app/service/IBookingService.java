package com.HunEee.hotel_booking_app.service;

import java.util.List;

import com.HunEee.hotel_booking_app.model.BookedRoom;

public interface IBookingService {
	
	List<BookedRoom> getAllBookingsByRoomId(Long roomId);

}
