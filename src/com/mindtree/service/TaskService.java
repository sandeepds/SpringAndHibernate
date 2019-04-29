package com.mindtree.service;

import java.util.List;
import java.util.Set;

import com.mindtree.entity.Employee;
import com.mindtree.entity.Project;
import com.mindtree.entity.ProjectTask;
import com.mindtree.exception.ServiceException;
import com.mindtree.model.TaskForm;

public interface TaskService {

	public List<Project> getListProjects() throws ServiceException;

	public List<Employee> getListEmployees() throws ServiceException;

	public void saveTaskAssign(TaskForm taskForm) throws ServiceException;

	public List<Employee> getEmployeesByProject(int projectId) throws ServiceException;
	
	public List<ProjectTask> getAllProjectsTaskDetails() throws ServiceException;
	
	public List<ProjectTask> getTaskDetailsByProjectId(Integer projectId) throws ServiceException;
	
	public List<Employee> getEmployeeListByTask(int projectTaskId) throws ServiceException;
}
