package com.nguyenngochien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyenngochien.entity.ProjectManage;

@Repository
public interface ProjectManageRepository extends JpaRepository<ProjectManage, Long>{
	List<ProjectManage> findByProjectId(Long projId);
	List<ProjectManage> findByEmployeeEid(Long eid);
}
