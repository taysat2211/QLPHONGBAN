package com.nguyenngochien.service;

import java.util.List;

import com.nguyenngochien.entity.Employee;

public interface EmployeeService {
	Iterable<Employee> findAll();
	List<Employee> search(String name);
	Employee findOne(long id);
	Employee save(Employee emp);
	void delete(long id);
}
