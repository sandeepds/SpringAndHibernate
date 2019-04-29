package com.mindtree.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Employee;
import com.mindtree.entity.Project;
import com.mindtree.entity.ProjectTask;
import com.mindtree.exception.FetcherException;

@Repository
public class TaskDaoImpl implements TaskDao {

	private static Logger logger = Logger.getLogger(TaskDaoImpl.class);
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

		@Override
		public List<Project> getListProjects() throws FetcherException{
	
			// get the current hibernate session
			Session session = sessionFactory.openSession();
	
			// create a query
			Query theQuery = session.createQuery("from Project");
	
			// get the result list from the query by executing it
			List<Project> listOfProjects = theQuery.list();
			logger.info("getting all projects list : listOfProjects::"+listOfProjects);
			return listOfProjects;
		}
	

	public Employee getEmployeesById(String mId) throws FetcherException{
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, mId);
		logger.info("getting employees by Id : "+emp);
		return emp;
	}

	public Project getProjectById(Integer id) throws FetcherException{
		Session session = sessionFactory.getCurrentSession();
		Project project = (Project) session.get(Project.class, id);
		logger.info("Getting project by ID : "+project);
		return project;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getListEmployees() throws FetcherException{
		Session session = sessionFactory.getCurrentSession();

		// create a query
		Query theQuery = session.createQuery("from Employee");

		// get the result list from the query by executing it
		List<Employee> listOfEmployees = theQuery.list();
		logger.info("Getting all employees : listOfEmployees"+listOfEmployees);
		return listOfEmployees;
	}

	@Override
	public void saveTaskAssign(ProjectTask projectTask) throws FetcherException,PersistenceException{
		System.out.println("Inside the task saver Dao layer " + projectTask);
		logger.info("Saving the project task in the data base table");
		// get the current hibernate session
		try{
		Session currentSession = sessionFactory.getCurrentSession();

		// save/update the customer
		currentSession.saveOrUpdate(projectTask);
		}
		catch(Exception e){
			throw new FetcherException();
		}
		// throw new FetcherException();
	}

	@Override
	public List<Employee> getEmployeesByProject(int projectId) throws FetcherException{
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query theQuery = currentSession.createQuery("from Employee where project.projectId = " + projectId);

		// get the result list from the query by executing it
		List<Employee> listOfEmployeesByProject = theQuery.list();
		logger.info("Getting employees by project : listOfEmployeesByProject"+listOfEmployeesByProject);
		return listOfEmployeesByProject;
	}

	
	// get all tasks details
	@Override
	public List<ProjectTask> getAllProjectsTaskDetails() throws FetcherException{
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query theQuery = currentSession.createQuery("from ProjectTask");

		// get the result list from the query by executing it
		List<ProjectTask> listOfProjectTasks = theQuery.list();
		logger.info("All task details: listOfProjectTasks"+listOfProjectTasks);
		return listOfProjectTasks;

	}

	// get all tasks details based on project ID
	@Override
	public List<ProjectTask> getTaskDetailsByProjectId(Integer projectId) throws FetcherException
	{
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query theQuery = currentSession.createQuery("from ProjectTask where project.projectId="+projectId);

		// get the result list from the query by executing it
		List<ProjectTask> listOfTasksByProjectId = theQuery.list();
		logger.info(" Task details by Project ID listOfTasksByProjectId"+listOfTasksByProjectId);
		return listOfTasksByProjectId;
	}

	// get the employee list based on the project task Id
	@Override
	public List<Employee> getEmployeeListByTask(int projectTaskId) throws FetcherException{
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query theQuery = currentSession.createQuery("from ProjectTask where projectTaskId="+projectTaskId);

		// get the result list from the query by executing it
		List<ProjectTask> listOfTasksByTaskId = theQuery.list();
		
		// create a set of employees object to store the employees list fetched from the project task
		List<Employee> employeeList = new ArrayList<Employee>();
		
		// inserting employee list fetched from ProjectTask into the Employee set
		for(ProjectTask insertTask : listOfTasksByTaskId)
		{
			for(Employee empSet : insertTask.getListOfEmployees())
			{
				employeeList.add(empSet);
			}
		}
		logger.info("employeeList By Tasks"+employeeList);
		return employeeList;
	}
	
	
	
	
	
}
