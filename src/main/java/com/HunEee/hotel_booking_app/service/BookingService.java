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

	@Override
	public List<BookedRoom> getAllBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookedRoom findByBookingConfirmationCode(String confirmationCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveBooking(Long roomId, BookedRoom bookingRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelBooking(Long bookingId) {
		// TODO Auto-generated method stub
		
	}
}
