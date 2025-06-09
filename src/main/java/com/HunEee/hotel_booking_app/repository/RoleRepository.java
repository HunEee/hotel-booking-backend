package com.HunEee.hotel_booking_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HunEee.hotel_booking_app.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	 Optional<Role> findByName(String string);

}
