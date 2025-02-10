package com.ace.springdatajpademo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import com.ace.springdatajpademo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findEmployeeByFirstNameAndLastName(String firstName, String lastName);
	List<Employee> findByFirstNameLike(String firstName);
	List<Employee> findByFirstNameLikeOrLastNameLike(String firstName, String lastName);
	
	@Query("select emp from Employee emp where emp.firstName=?1")
	List<Employee> selectEmployeeByFirstName(String firstName);
	
	@NativeQuery("SELECT FIRST_NAME, LAST_NAME, DEPARTMENT, DESIGNATION, SALARY, ID FROM HR.EMPLOYEE WHERE EMPLOYEE.DEPARTMENT = ?1")
	List<Employee> selectEmployeesByDepartment(String department);
	
	@Query(value = "SELECT FIRST_NAME, LAST_NAME, DEPARTMENT, DESIGNATION, SALARY, ID FROM HR.EMPLOYEE WHERE EMPLOYEE.FIRST_NAME = ?1 AND EMPLOYEE.LAST_NAME =?2", nativeQuery = true)
	Map<String, Object> selectEmployeeByName(String firstName, String lastName);
	
	@Query(value = "SELECT * FROM HR.EMPLOYEE WHERE EMPLOYEE.SALARY BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Map<String, Object>> selectEmployeesBySalaryRange(Double firstName, Double salaryEnd);
}
