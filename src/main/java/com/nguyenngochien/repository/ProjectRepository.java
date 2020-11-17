package com.nguyenngochien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyenngochien.entity.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	List<Project> findByNameContaining(String name);
}
