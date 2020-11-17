package com.nguyenngochien.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenngochien.entity.Department;
import com.nguyenngochien.repository.DepartmentRepository;
import com.nguyenngochien.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Iterable<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public List<Department> search(String name) {
		return departmentRepository.findByNameContaining(name);
	}

	@Override
	public Department findOne(long id) {
		return departmentRepository.findById(id).orElseThrow();
	}

	@Override
	public Department save(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public void delete(long id) {
		departmentRepository.deleteById(id);
		
	}
}
