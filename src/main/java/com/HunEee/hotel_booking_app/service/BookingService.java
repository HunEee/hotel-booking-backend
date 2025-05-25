package com.HunEee.hotel_booking_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HunEee.hotel_booking_app.model.BookedRoom;
import com.HunEee.hotel_booking_app.repository.BookingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService implements IBookingService {
	
	private final BookingRepository bookingRepository;
	
	@Override
	public List<BookedRoom> getAllBookingsByRoomId(Long roomId) {
	    return bookingRepository.findByRoomId(roomId);
	}
}
