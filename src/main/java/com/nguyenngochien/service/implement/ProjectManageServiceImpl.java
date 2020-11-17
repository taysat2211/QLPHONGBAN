package com.nguyenngochien.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenngochien.entity.ProjectManage;
import com.nguyenngochien.repository.ProjectManageRepository;
import com.nguyenngochien.service.ProjectManageService;

@Service
public class ProjectManageServiceImpl implements ProjectManageService{
	
	@Autowired
	private ProjectManageRepository projectManageRepository;
	@Override
	public Iterable<ProjectManage> findAll() {
		return projectManageRepository.findAll();
	}

	@Override
	public List<ProjectManage> findByProjectId(long id) {
		return projectManageRepository.findByProjectId(id);
	}

	@Override
	public List<ProjectManage> findByEmployeeId(long id) {
		return projectManageRepository.findByEmployeeEid(id);
	}

	@Override
	public ProjectManage findOne(long id) {
		return projectManageRepository.findById(id).orElseThrow();
	}

	@Override
	public ProjectManage save(ProjectManage projManage) {
		return projectManageRepository.save(projManage);
	}

	@Override
	public void delete(long id) {
		projectManageRepository.deleteById(id);
		
	}

}
