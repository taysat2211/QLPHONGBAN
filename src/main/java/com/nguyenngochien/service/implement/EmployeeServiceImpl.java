package com.nguyenngochien.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenngochien.entity.Employee;
import com.nguyenngochien.repository.EmployeeRepository;
import com.nguyenngochien.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> search(String name) {
		return employeeRepository.findByNameContaining(name);
	}

	@Override
	public Employee findOne(long id) {
		return employeeRepository.findById(id).orElseThrow();
	}

	@Override
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public void delete(long id) {
		employeeRepository.deleteById(id);
	}

}
