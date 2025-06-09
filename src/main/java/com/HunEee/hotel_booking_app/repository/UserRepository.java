package com.HunEee.hotel_booking_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HunEee.hotel_booking_app.model.User;

public interface UserRepository extends JpaRepository<User, Long>  {

	public boolean existsByEmail(String email);

	public Optional<User> findByEmail(String email);

	public void deleteByEmail(String email);

}
