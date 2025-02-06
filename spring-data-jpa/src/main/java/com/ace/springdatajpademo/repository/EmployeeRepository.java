package com.ace.springdatajpademo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ace.springdatajpademo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findEmployeeByFirstNameAndLastName(String firstName, String lastName);
}
