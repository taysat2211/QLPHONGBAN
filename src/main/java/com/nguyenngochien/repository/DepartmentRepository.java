package com.nguyenngochien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyenngochien.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	List<Department> findByNameContaining(String name);
}
