package com.nguyenngochien.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "numberOfEmp")
	private int numberOfEmp;
	
	@Column(name = "cost")
	private double cost;
	
	@Column(name = "begin")
	private Date begin;
	
	@Column(name = "end")
	private Date end;

	public Project() {
		super();
	}

	public Project(long id, String name, String location, int numberOfEmp, double cost, Date begin, Date end) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.numberOfEmp = numberOfEmp;
		this.cost = cost;
		this.begin = begin;
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumberOfEmp() {
		return numberOfEmp;
	}

	public void setNumberOfEmp(int numberOfEmp) {
		this.numberOfEmp = numberOfEmp;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public long getId() {
		return id;
	}
	
	
}
