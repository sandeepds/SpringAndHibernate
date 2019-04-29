/**
 * 
 */
package com.mindtree.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author SSatpath
 *
 */
public class TaskForm {
	
	private Integer projectId;
	//private int projectTaskId;
	
	@NotBlank(message="description is required")
	private String projectTaskDescription;
	
	@NotNull(message="start date is required")
	private Date taskStartDate;
	
	@NotNull(message="end date is required")
	private Date taskEndDate;
	
	//private List<Employee> listOfEmployees;
	private List<String> listOfEmployees;
	
	public String getProjectTaskDescription() {
		return projectTaskDescription;
	}
	public void setProjectTaskDescription(String projectTaskDescription) {
		this.projectTaskDescription = projectTaskDescription;
	}
	public Date getTaskStartDate() {
		return taskStartDate;
	}
	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}
	public Date getTaskEndDate() {
		return taskEndDate;
	}
	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}
	public List<String> getListOfEmployees() {
		return listOfEmployees;
	}
	public void setListOfEmployees(List<String> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	@Override
	public String toString() {
		return "TaskForm [projectId=" + projectId + ", projectTaskDescription=" + projectTaskDescription
				+ ", taskStartDate=" + taskStartDate + ", taskEndDate=" + taskEndDate + ", listOfEmployees="
				+ listOfEmployees + "]";
	}
	
	
	
}
