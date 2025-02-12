package com.ace.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class DemoController {
	@RequestMapping("/")
	public String helloWorld(HttpServletRequest request) {
		return "Hello from Spring Security - "+request.getSession().getId();
	}
}
