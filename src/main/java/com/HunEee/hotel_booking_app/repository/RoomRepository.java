package com.HunEee.hotel_booking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HunEee.hotel_booking_app.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

	Room save(Room room);

}
