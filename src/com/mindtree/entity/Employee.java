package com.mindtree.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;

@Entity
@Table(name="EMPLOYEES")
public class Employee {
	
	static Logger logger = Logger.getLogger(Employee.class.getName());

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PROJECT_ID")
	private Project project;


	@Id
	@Column(name="MID")
	private String empId;
	
	@Column(name="EMP_NAME")
	private String empName;
	
		
	public Employee()
	{
		
	}

	public Employee(String empId, String empName) {
		
		this.empId = empId;
		this.empName = empName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", empName=" + empName + "]";
	}

		
}

