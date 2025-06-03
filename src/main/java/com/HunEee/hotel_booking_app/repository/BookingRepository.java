package com.HunEee.hotel_booking_app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HunEee.hotel_booking_app.model.BookedRoom;
import com.HunEee.hotel_booking_app.model.Room;

public interface BookingRepository extends JpaRepository<BookedRoom, Long>{

	List<BookedRoom> findByRoomId(Long roomId);

	Optional<BookedRoom> findByBookingConfirmationCode(String confirmationCode);
	
}
