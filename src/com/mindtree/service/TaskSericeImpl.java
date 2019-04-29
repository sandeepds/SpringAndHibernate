package com.mindtree.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.dao.TaskDao;
import com.mindtree.entity.Employee;
import com.mindtree.entity.Project;
import com.mindtree.entity.ProjectTask;
import com.mindtree.exception.DaoException;
import com.mindtree.exception.ServiceException;
import com.mindtree.model.TaskForm;

@Service
public class TaskSericeImpl implements TaskService {

	// need to inject taskDao
	@Autowired
	private TaskDao taskDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Project> getListProjects() throws ServiceException {
		
		try {
			return taskDao.getListProjects();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException("Dataase error");
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Employee> getListEmployees() throws ServiceException{
		try {
			return taskDao.getListEmployees();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException("Dataase error");
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveTaskAssign(TaskForm taskForm) throws ServiceException{
		System.out.println("Inside the Service Layer");
		ProjectTask projectTask = new ProjectTask();
		
		// inserting the form details into project task table
		projectTask.setProjectTaskDescription(taskForm.getProjectTaskDescription());
		System.out.println(taskForm.getProjectTaskDescription());
		
		// call to DAO , param is Project id , it returns Project   taskForm.getProjectId()
		Project project = taskDao.getProjectById(taskForm.getProjectId());
		
		projectTask.setProject(project);
		System.out.println(taskForm.getProjectId());
		
		projectTask.setEndDate(taskForm.getTaskEndDate());
		System.out.println(taskForm.getTaskEndDate());
		
		
		projectTask.setStartDate(taskForm.getTaskStartDate());
		System.out.println(taskForm.getTaskStartDate());
		
		System.out.println("Project Task Data : "+projectTask);
		
		// inserting the employee details into project task table
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		System.out.println(taskForm);
		System.out.println(taskForm.getListOfEmployees());
		
		for(String emp : taskForm.getListOfEmployees())
		{
			Employee employee = new Employee();
			employee = taskDao.getEmployeesById(emp);
			listOfEmployees.add(employee);
		}
		projectTask.setListOfEmployees(listOfEmployees);
		try{
			taskDao.saveTaskAssign(projectTask);
		}
		catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException("Dataase error");
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Employee> getEmployeesByProject(int projectId) throws ServiceException{
		try{
		return taskDao.getEmployeesByProject(projectId);
	}
	catch (DaoException e) {
		e.printStackTrace();
		throw new ServiceException("Dataase error");
	}
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<ProjectTask> getAllProjectsTaskDetails() throws ServiceException
	{
		try{
			return taskDao.getAllProjectsTaskDetails();
		}
		catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException("Dataase error");
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<ProjectTask> getTaskDetailsByProjectId(Integer projectId) throws ServiceException {
		try{	
		return taskDao.getTaskDetailsByProjectId(projectId);
		}
		catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException("Dataase error");
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Employee> getEmployeeListByTask(int projectTaskId) throws ServiceException {
		
		try
		{
			return taskDao.getEmployeeListByTask(projectTaskId);
			}
		catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException("Dataase error");
		}
	}

}
