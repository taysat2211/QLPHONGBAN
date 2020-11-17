package com.nguyenngochien.service;

import java.util.List;

import com.nguyenngochien.entity.ProjectManage;

public interface ProjectManageService {
	Iterable<ProjectManage> findAll();
	List<ProjectManage> findByProjectId(long id);
	List<ProjectManage> findByEmployeeId(long id);
	ProjectManage findOne(long id);
	ProjectManage save(ProjectManage projManage);
	void delete(long id);
}
