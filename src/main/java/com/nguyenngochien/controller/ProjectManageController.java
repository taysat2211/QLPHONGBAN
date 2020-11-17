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

import com.nguyenngochien.entity.ProjectManage;
import com.nguyenngochien.service.implement.ProjectManageServiceImpl;

@RestController
public class ProjectManageController {
	@Autowired
	private ProjectManageServiceImpl projectManageService;

	@GetMapping(value = "/project-manage")
	public List<ProjectManage> getAllProjectManage() {
		return (List<ProjectManage>) projectManageService.findAll();
	}

	@GetMapping(value = "/project-manage/{id}")
	public ProjectManage getProjectManageById(@PathVariable(value = "id") Long projMngId) {
		ProjectManage projMng = projectManageService.findOne(projMngId);
		return projMng;
	}

	@PostMapping(value = "/project-manage")
	public ProjectManage createProjectManage(@RequestBody ProjectManage projMng) {
		return projectManageService.save(projMng);
	}

	@PutMapping(value = "/project-manage/{id}")
	public ResponseEntity<ProjectManage> updateProjectManage(@PathVariable(value = "id") Long projMngId,
			@RequestBody ProjectManage projMng) {
		ProjectManage saveProjectManage = projectManageService.findOne(projMngId);
		saveProjectManage.setEmployee(projMng.getEmployee());
		saveProjectManage.setProject(projMng.getProject());
		saveProjectManage.setPayment(projMng.getPayment());
		saveProjectManage.setJoinDate(projMng.getJoinDate());
		projectManageService.save(saveProjectManage);
		return ResponseEntity.ok(saveProjectManage);
	}
	
	@DeleteMapping(value = "/project-manage/{id}")
	public List<ProjectManage> deleteProjectManage(@PathVariable(value = "id") Long projectManageId){
		projectManageService.delete(projectManageId);
		return (List<ProjectManage>) projectManageService.findAll();
	}
	
	@GetMapping(value = "/project-manage/project-detail/{id}")
	public List<ProjectManage> findProjectManageByProjectId(@PathVariable(value = "id") Long projectId){
//		Project proj = projRepository.findById(projectId).orElseThrow();
		return projectManageService.findByProjectId(projectId);
	}
	
	@GetMapping(value = "/project-manage/employee/{id}")
	public List<ProjectManage> findProjectManageByEmployeeId(@PathVariable(value = "id") Long eid){
		return projectManageService.findByEmployeeId(eid);
	}
}
