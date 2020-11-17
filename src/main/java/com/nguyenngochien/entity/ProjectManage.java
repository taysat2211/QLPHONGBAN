package com.nguyenngochien.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project_manage")
public class ProjectManage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "pid")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name = "eid")
	private Employee employee;
	
	@Column(name = "payment")
	private double payment;
	
	@Column(name = "joinDate")
	private Date joinDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public ProjectManage(Long id, Project project, Employee employee, double payment, Date joinDate) {
		super();
		this.id = id;
		this.project = project;
		this.employee = employee;
		this.payment = payment;
		this.joinDate = joinDate;
	}

	public ProjectManage() {
		super();
	}
	
	
}
