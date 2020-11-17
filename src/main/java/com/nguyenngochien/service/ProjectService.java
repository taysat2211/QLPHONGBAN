package com.nguyenngochien.service;

import java.util.List;

import com.nguyenngochien.entity.Project;

public interface ProjectService {
	Iterable<Project> findAll();
	List<Project> search(String name);
	Project findOne(long id);
	Project save(Project proj);
	void delete(long id);
}
