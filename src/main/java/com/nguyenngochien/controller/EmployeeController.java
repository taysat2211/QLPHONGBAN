package com.nguyenngochien.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenngochien.entity.Employee;
import com.nguyenngochien.service.implement.EmployeeServiceImpl;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@GetMapping(value = "/employee")
	public List<Employee> getAllEmployee(){
		return (List<Employee>) employeeService.findAll();
	}
	
	@GetMapping(value = "/employee/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") Long employeeId){
		Employee emp = employeeService.findOne(employeeId);
		return emp;
	}
	
	
	@PostMapping(value = "/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	
	@PutMapping(value = "/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@RequestBody Employee employee){
		Employee emp = employeeService.findOne(employeeId);	
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		emp.setDepartment(employee.getDepartment());
		final Employee updateEmp = employeeService.save(emp);
		return ResponseEntity.ok(updateEmp);
	}
	
	@DeleteMapping(value = "/employee/{id}")
	public List<Employee> deleteEmployee(@PathVariable(value = "id") Long employeeId){
		employeeService.delete(employeeId);
		return (List<Employee>) employeeService.findAll();
	}
}
