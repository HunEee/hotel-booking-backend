package com.HunEee.hotel_booking_app.service;

import java.util.List;

import com.HunEee.hotel_booking_app.model.User;

public interface IUserService {

    User registerUser(User user);
    List<User> getUsers();
    void deleteUser(String email);
    User getUser(String email);
	
}
