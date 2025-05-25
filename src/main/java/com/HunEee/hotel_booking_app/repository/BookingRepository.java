package com.HunEee.hotel_booking_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HunEee.hotel_booking_app.model.BookedRoom;

public interface BookingRepository extends JpaRepository<BookedRoom, Long>{

	 List<BookedRoom> findByRoomId(Long roomId);
	
}
