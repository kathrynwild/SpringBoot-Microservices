package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployeeDetails();

	Optional<Employee> getEmployeeById(String empId);

	Employee addEmployee(Employee emp);

	void deleteEmployee(String empId);

	Employee updateEmployee(String empId, Employee employee);

}