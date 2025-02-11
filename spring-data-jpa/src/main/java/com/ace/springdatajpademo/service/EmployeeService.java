package com.ace.springdatajpademo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ace.springdatajpademo.entity.Employee;
import com.ace.springdatajpademo.repository.EmployeeRepository;

import static org.springframework.data.domain.ExampleMatcher.*;

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
	
	public List<Employee> getEmployeeByFirstName(String firstName) {
		return this.employeeRepository.selectEmployeeByFirstName(firstName);
	}
	
	public List<Employee> getEmployeesByDepartment(String department) {
		return this.employeeRepository.selectEmployeesByDepartment(department);
	}
	
	public Map<String, Object> getEmployeeInMap(String firstName, String lastName) {
		return this.employeeRepository.selectEmployeeByName(firstName, lastName);
	}
	
	public List<Map<String, Object>> getEmployeesBySalaryRange(Double firstName, Double salaryEnd) {
		return this.employeeRepository.selectEmployeesBySalaryRange(firstName, salaryEnd);
	}
	
	public Page<Employee> findAll(int page, int size, String ... property) {
		PageRequest pr = PageRequest.of(page, size, Sort.by(Direction.ASC, property));
		return this.employeeRepository.findAll(pr);
	}
	
	public List<Employee> findAll(Employee employee) {
		ExampleMatcher exampleMatcher = matching()
									.withIgnoreCase()
									.withStringMatcher(StringMatcher.CONTAINING)
									.withIgnoreNullValues();
		Example<Employee> example = Example.of(employee, exampleMatcher);
		return this.employeeRepository.findAll(example);
	}
}
