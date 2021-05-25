package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.Employee;
import com.capgemini.exceptions.EmployeeNotFoundException;
import com.capgemini.repo.EmployeeRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Override
	public List<Employee> getAllEmployeeDetails() {
		return employeeRepo.findAll();
	}
	
	@Override
	public Optional<Employee> getEmployeeById(String empId) throws EmployeeNotFoundException {
		if(employeeRepo.findById(empId) == null) {
			throw new EmployeeNotFoundException("Employee Not Found");
		}
		
		return employeeRepo.findById(empId);
	}

	@Override
	public Employee addEmployee(Employee emp) {
		return employeeRepo.save(emp);
	}
	
	@Override
	public void deleteEmployee(String empId) {
		employeeRepo.deleteById(empId);
	}
	
	@Override
	public Employee updateEmployee(String empId, Employee employee) {
		employeeRepo.deleteById(empId);
		return employeeRepo.save(employee);
	}
}
