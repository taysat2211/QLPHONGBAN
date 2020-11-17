package com.nguyenngochien.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenngochien.entity.Project;
import com.nguyenngochien.repository.ProjectRepository;
import com.nguyenngochien.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Iterable<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	public List<Project> search(String name) {
		return projectRepository.findByNameContaining(name);
	}

	@Override
	public Project findOne(long id) {
		return projectRepository.findById(id).orElseThrow();
	}

	@Override
	public Project save(Project proj) {
		return projectRepository.save(proj);
	}

	@Override
	public void delete(long id) {
		projectRepository.deleteById(id);
	}

}
