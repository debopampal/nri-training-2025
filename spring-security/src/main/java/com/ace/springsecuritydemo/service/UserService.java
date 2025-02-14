package com.ace.springsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ace.springsecuritydemo.entity.Users;
import com.ace.springsecuritydemo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public Users save(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return this.userRepository.save(user);
	}
	
	public String verify(Users user) {
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authenticate.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		} else {
			return "fail";
		}
	}
}
