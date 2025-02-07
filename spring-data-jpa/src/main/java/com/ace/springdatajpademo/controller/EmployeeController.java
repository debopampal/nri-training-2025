package com.ace.springdatajpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ace.springdatajpademo.entity.Employee;
import com.ace.springdatajpademo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/search")
	public ResponseEntity<List<Employee>> searchEmployee(
			@RequestParam() String firstName,
			@RequestParam(required = false) String lastName
	) {
		List<Employee> employees = lastName != null
				? this.employeeService.getEmployeesByFirstNameAndLastName(firstName, lastName)
				: this.employeeService.getEmployeesByFirstNameLike(firstName);
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/searchByName")
	public ResponseEntity<List<Employee>> searchEmployeeByName(
			@RequestParam() String firstName,
			@RequestParam() String lastName
	) {
		List<Employee> employees = this.employeeService.getEmployeesByFirstNameLikeOrLastNameLike(firstName, lastName);
		return ResponseEntity.ok(employees);
	}
}