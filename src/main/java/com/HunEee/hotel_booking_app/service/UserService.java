package com.HunEee.hotel_booking_app.service;

import java.util.Collections;
import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.HunEee.hotel_booking_app.exception.UserAlreadyExistsException;
import com.HunEee.hotel_booking_app.model.Role;
import com.HunEee.hotel_booking_app.model.User;
import com.HunEee.hotel_booking_app.repository.RoleRepository;
import com.HunEee.hotel_booking_app.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final RoleRepository roleRepository;
	
	@Override
	public User registerUser(User user) {
	    if (userRepository.existsByEmail(user.getEmail())){
	        throw new UserAlreadyExistsException(user.getEmail() + " already exists");
	    }
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    System.out.println(user.getPassword());
	    Role userRole = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("ROLE_USER not found"));
	    user.setRoles(Collections.singletonList(userRole));
	    return userRepository.save(user);
	}
	
	@Override
	public List<User> getUsers() {
	    return userRepository.findAll();
	}
	
	@Transactional
	@Override
	public void deleteUser(String email) {
	    User theUser = getUser(email);
	    if (theUser != null){
	        userRepository.deleteByEmail(email);
	    }
	
	}
	
	@Override
	public User getUser(String email) {
	    return userRepository.findByEmail(email)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}

}
