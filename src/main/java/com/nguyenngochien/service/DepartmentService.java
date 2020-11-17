package com.nguyenngochien.service;

import java.util.List;

import com.nguyenngochien.entity.Department;

public interface DepartmentService {
	
	Iterable<Department> findAll();
	
	List<Department> search(String name);
	
	Department findOne(long id);
	
	Department save(Department department);
	
	void delete(long id);	
}
