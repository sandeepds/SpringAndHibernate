package com.mindtree.model;

import java.util.List;

import com.mindtree.entity.Employee;

public class ViewTaskForm {
	
	private Integer taskId;
	private String taskDescription;
	private String taskStartDate;
	private String taskEndDate;
	private List<Employee> employess;
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public String getTaskStartDate() {
		return taskStartDate;
	}
	public void setTaskStartDate(String taskStartDate) {
		this.taskStartDate = taskStartDate;
	}
	public String getTaskEndDate() {
		return taskEndDate;
	}
	public void setTaskEndDate(String taskEndDate) {
		this.taskEndDate = taskEndDate;
	}
	public List<Employee> getEmployess() {
		return employess;
	}
	public void setEmployess(List<Employee> employess) {
		this.employess = employess;
	}
	@Override
	public String toString() {
		return "ViewTaskForm [taskId=" + taskId + ", taskDescription=" + taskDescription + ", taskStartDate="
				+ taskStartDate + ", taskEndDate=" + taskEndDate + ", employess=" + employess + "]";
	}
	public ViewTaskForm(Integer taskId, String taskDescription, String taskStartDate, String taskEndDate,
			List<Employee> employess) {
	
		this.taskId = taskId;
		this.taskDescription = taskDescription;
		this.taskStartDate = taskStartDate;
		this.taskEndDate = taskEndDate;
		this.employess = employess;
	}
	
	

}
