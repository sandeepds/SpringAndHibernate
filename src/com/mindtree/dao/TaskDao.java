package com.mindtree.dao;

import java.util.List;
import java.util.Set;


import com.mindtree.entity.Employee;
import com.mindtree.entity.Project;
import com.mindtree.entity.ProjectTask;
import com.mindtree.exception.FetcherException;
import com.mindtree.exception.PersistenceException;

public interface TaskDao {

	public List<Project> getListProjects() throws FetcherException;

	public List<Employee> getListEmployees() throws FetcherException;

	public void saveTaskAssign(ProjectTask projectTask) throws FetcherException, PersistenceException;

	public List<Employee> getEmployeesByProject(int projectId) throws FetcherException;
	
	public Employee getEmployeesById(String mId) throws FetcherException;
	
	public Project getProjectById(Integer id) throws FetcherException;
	
	public List<ProjectTask> getAllProjectsTaskDetails() throws FetcherException;
	
	public List<ProjectTask> getTaskDetailsByProjectId(Integer projectId) throws FetcherException;
	
	public List<Employee> getEmployeeListByTask(int projectTaskId) throws FetcherException;
}
