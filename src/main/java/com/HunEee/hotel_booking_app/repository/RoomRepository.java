package com.HunEee.hotel_booking_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.HunEee.hotel_booking_app.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

	@Query("SELECT DISTINCT r.roomType FROM Room r")
	List<String> findDistinctRoomTypes();

}
