package com.ace.springsecuritydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ace.springsecuritydemo.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	Users findByUsername(String username);
}
