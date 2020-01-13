package com.example.PPMT.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.PPMT.domain.User;
import com.example.PPMT.repositories.UserRepository;

public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User saveUser(User newUser) {
		newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
		return userRepository.save(newUser);
	}
}
