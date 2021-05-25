package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.entity.Employee;
import com.capgemini.exceptions.EmployeeNotFoundException;

public interface EmployeeService {

	List<Employee> getAllEmployeeDetails();

	Optional<Employee> getEmployeeById(String empId) throws EmployeeNotFoundException;

	Employee addEmployee(Employee emp);

	void deleteEmployee(String empId);

	Employee updateEmployee(String empId, Employee employee);

}