package com.ace.springdatajpademo.controller;

import java.util.List;
import java.util.Map;

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
//				: this.employeeService.getEmployeesByFirstNameLike(firstName);
				: this.employeeService.getEmployeeByFirstName(firstName);
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
	
	@GetMapping("/searchByDepartment")
	public ResponseEntity<List<Employee>> searchEmpployeeByDepartment(@RequestParam() String department) {
		List<Employee> employees = this.employeeService.getEmployeesByDepartment(department);
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/getEmployeeInMap")
	public ResponseEntity<Map<String, Object>> getEmployeeInMap(
			@RequestParam() String firstName,
			@RequestParam() String lastName
	) {
		Map<String, Object> employee = this.employeeService.getEmployeeInMap(firstName, lastName);
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/getEmployeesWithinSalaryRange")
	public ResponseEntity<List<Map<String, Object>>> getEmployeesBySalaryRange(
			@RequestParam() Double salaryStart,
			@RequestParam() Double salaryEnd
	) {
		List<Map<String, Object>> employee = this.employeeService.getEmployeesBySalaryRange(salaryStart, salaryEnd);
		return ResponseEntity.ok(employee);
	}
	
}