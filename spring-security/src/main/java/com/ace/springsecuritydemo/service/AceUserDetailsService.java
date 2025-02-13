package com.ace.springsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ace.springsecuritydemo.entity.Users;
import com.ace.springsecuritydemo.model.AceUserDetails;
import com.ace.springsecuritydemo.repository.UserRepository;

@Service
public class AceUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = this.userRepository.findByUsername(username);
		if(user == null) {
			System.out.println("No user found");
			throw new UsernameNotFoundException(String.format("User - %s not found", username));
		}
		
		return new AceUserDetails(user);
	}

}
