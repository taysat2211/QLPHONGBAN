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

import com.nguyenngochien.service.implement.ProjectServiceImpl;
import com.nguyenngochien.entity.Project;

@RestController
public class ProjectController {
	@Autowired
	private ProjectServiceImpl projectService;
	
	@GetMapping(value = "/project")
	public List<Project> getAllProject(){
		return (List<Project>) projectService.findAll();
	}
	
	@GetMapping(value = "/project/{id}")
	public Project getProjectById(@PathVariable(value = "id") Long projectId) {
		Project project = projectService.findOne(projectId);
		return project;
	}
	
	@PostMapping(value = "/project")
	public Project createProject(@RequestBody Project project) {
		return projectService.save(project);
	}
	
	@PutMapping(value = "/project/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable(value = "id") Long projectId,
			@RequestBody Project project){
		Project proj = projectService.findOne(projectId);
		proj.setName(project.getName());
		proj.setLocation(project.getLocation());
		proj.setCost(project.getCost());
		proj.setNumberOfEmp(project.getNumberOfEmp());
		proj.setBegin(project.getBegin());
		proj.setEnd(project.getEnd());
		final Project updateProj = projectService.save(proj);
		return ResponseEntity.ok(updateProj);
	}
	
	@DeleteMapping(value = "project/{id}")
	public List<Project> deleteProject(@PathVariable(value = "id") Long projId){
		projectService.delete(projId);
		return (List<Project>) projectService.findAll();
	}
}
