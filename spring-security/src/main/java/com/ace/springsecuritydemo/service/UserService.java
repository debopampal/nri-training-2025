package com.ace.springsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ace.springsecuritydemo.entity.Users;
import com.ace.springsecuritydemo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public Users save(Users user) {
		return this.userRepository.save(user);
	}
}
