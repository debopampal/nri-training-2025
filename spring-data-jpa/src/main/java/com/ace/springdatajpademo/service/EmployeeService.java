package com.ace.springdatajpademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ace.springdatajpademo.entity.Employee;
import com.ace.springdatajpademo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployeesByFirstNameAndLastName(String firstName, String lastName) {
		return this.employeeRepository.findEmployeeByFirstNameAndLastName(firstName, lastName);
	}
	
	public List<Employee> getEmployeesByFirstNameLike(String firstName) {
		return this.employeeRepository.findByFirstNameLike(String.format("%%%s%%", firstName));
	}
	
	public List<Employee> getEmployeesByFirstNameLikeOrLastNameLike(String firstName, String lastName) {
		return this.employeeRepository.findByFirstNameLikeOrLastNameLike(String.format("%%%s%%", firstName), String.format("%%%s%%", lastName));
	}
}
