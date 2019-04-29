package com.mindtree.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.Logger;

@Entity
@Table(name="TASKS")
public class ProjectTask {
	
	static Logger logger = Logger.getLogger(ProjectTask.class.getName());
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="PROJECT_ID")
	private Project project;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="Task_Employee",
				joinColumns=@JoinColumn(name="TASK_ID"),
				inverseJoinColumns=@JoinColumn(name="MID")
			  )
	private List<Employee> listOfEmployees = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TASK_ID")
	private int projectTaskId;
	
	
	public int getProjectTaskId() {
		return projectTaskId;
	}

	public void setProjectTaskId(int projectTaskId) {
		this.projectTaskId = projectTaskId;
	}

	@Column(name="TASK_DESCRIPTION")
	private String projectTaskDescription;
	
	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	public ProjectTask()
	{
		
	}

	public ProjectTask(String projectTaskDescription, Date startDate, Date endDate) {
		
		this.projectTaskDescription = projectTaskDescription;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	

	public String getProjectTaskDescription() {
		return projectTaskDescription;
	}

	public void setProjectTaskDescription(String projectTaskDescription) {
		this.projectTaskDescription = projectTaskDescription;
	}

	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "ProjectTasks [projectTaskId=" + projectTaskId + ", projectTaskDescription=" + projectTaskDescription
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Employee> getListOfEmployees() {
		return listOfEmployees;
	}

	public void setListOfEmployees(List<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}
	
	
}
