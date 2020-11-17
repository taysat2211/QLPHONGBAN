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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenngochien.entity.Department;
import com.nguyenngochien.service.implement.DepartmentServiceImpl;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentServiceImpl departmentService;
	
	@GetMapping(value = "/department")
	public List<Department> getAllDepartment(){
		return (List<Department>) departmentService.findAll();
	}
	
	@GetMapping(value = "/department/{id}")
	public Department getDepartmentById(@PathVariable(value = "id") Long departmentId){
		Department department = departmentService.findOne(departmentId);
		return department;
	}
	
	@PostMapping(value = "/department")
	public Department createDepartment(@RequestBody Department department) {
		return departmentService.save(department);
	}
	
	@PutMapping(value = "/department/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable(value = "id") Long departmentId, @RequestBody Department department){
		
		Department dep = departmentService.findOne(departmentId);
		dep.setName(department.getName());
		
		final Department updateDep = departmentService.save(dep);
		return ResponseEntity.ok(updateDep);
	}
	
	@DeleteMapping(value = "/department/{id}")
	public List<Department> deleteDepartment(@PathVariable(value = "id") Long departmentId){
		departmentService.delete(departmentId);
		return (List<Department>) departmentService.findAll();	
	}
	
	@GetMapping(value = "/search/department")
	public List<Department> searchDepartment(@RequestParam(value = "name") String name){
		return departmentService.search(name);
	}
}
