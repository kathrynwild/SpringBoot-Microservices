package com.capgemini.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.Employee;
import com.capgemini.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployeeDetails(){
		return employeeService.getAllEmployeeDetails();
	}
	
	@GetMapping("/employee/{empId}")
	public Optional<Employee> getEmployeeById(@PathVariable String empId) {
		return employeeService.getEmployeeById(empId);
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@DeleteMapping("/employee/{empId}")
	public void deleteEmployee(@PathVariable String empId) {
		employeeService.deleteEmployee(empId);
	}
	
	@PutMapping("/employee/{empId}")
	public Employee updateEmployee(@PathVariable String empId, @RequestBody Employee employee) {
		return employeeService.updateEmployee(empId, employee);
	}
}

//{"empId": "101", "name": "Kat",  "designation": "Engineer", "salary": 100000}
// localhost:8080/employee/101/{"empId": "101", "name": "Kat", "designation": "Student", "salary": 10000.0}
