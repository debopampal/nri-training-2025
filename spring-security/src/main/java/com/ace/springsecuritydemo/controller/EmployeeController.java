package com.ace.springsecuritydemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ace.springsecuritydemo.entity.Employee;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	private List<Employee> emps = new ArrayList<>(
			List.of(
					new Employee(1L, "Rohit", "Dey", "IT", "Sr. Engineer", 1500000D),
					new Employee(2L, "Divya", "Jain", "IT", "Project Manager", 1600000D)
			));

	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@GetMapping("/list")
	public List<Employee> findAll() {
		return emps;
	}
	
	@PostMapping("/add")
	public Employee addEmpployee(@RequestBody Employee employee) {
		this.emps.add(employee);
		return employee;
	}
}
