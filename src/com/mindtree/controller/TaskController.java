package com.mindtree.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.entity.Employee;
import com.mindtree.entity.Project;
import com.mindtree.entity.ProjectTask;
import com.mindtree.exception.ServiceException;
import com.mindtree.model.TaskForm;
import com.mindtree.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {

	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(TaskController.class);

	
	// need to inject the task service
	@Autowired
	private TaskService taskService;

	@RequestMapping("/assignTask")
	public String assignTask(Model theModel) {
		System.out.println("IN controller");
		
		List<Project> theProjects;
		try {
			theProjects = taskService.getListProjects();
		} catch (ServiceException e) {
			e.printStackTrace();
			return "error";
		}

		try {
			List<Employee> theEmployees = taskService.getListEmployees();
		} catch (ServiceException e) {
			e.printStackTrace();
			return "error";
		}

		theModel.addAttribute("projectlist", theProjects);

		//theModel.addAttribute("employeelist", theEmployees);

		theModel.addAttribute("taskForm", new TaskForm());

		return "assigntask-form";

	}

	public List<Project> listOfProjects() {
		List<Project> listOfProj = null;
		// get the project list from the service
		try {
			listOfProj= taskService.getListProjects();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return listOfProj;
	}

	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public String addTask(@Valid @ModelAttribute("taskForm") TaskForm taskForm, BindingResult theBindingResult, Model theModel) {

		System.out.println("INside the task add controller");
		System.out.println(taskForm.toString());
		if(theBindingResult.hasErrors())
		{
			List<Project> theProjects=null;
			try {
				theProjects = taskService.getListProjects();
			} catch (ServiceException e) {
				e.printStackTrace();
				return "error";
			}

			try {
				List<Employee> theEmployees = taskService.getListEmployees();
			} catch (ServiceException e) {
				e.printStackTrace();
				return "error";
			}
			//ModelAndView model=new ModelAndView();

			theModel.addAttribute("projectlist", theProjects);

			//theModel.addAttribute("employeelist", theEmployees);

			//theModel.addAttribute("taskForm", new TaskForm());
			return "assigntask-form";
		}
		else
		{
			try {
				taskService.saveTaskAssign(taskForm);
			} catch (ServiceException e) {
				return "error";
			}
			theModel.addAttribute("successMsg", "Task has been added successfully");
			return "forward:/task/assignTask";
		}

	}

	@RequestMapping(value = "/taskView", method = RequestMethod.GET)
	public String taskView(Model model){
		
		model.addAttribute("project", new Project());
		model.addAttribute("projectList", listOfProjects());
		return "taskview-form";

	}
	
	
	
	@RequestMapping(value = "/loadEmployeesList", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getEmployeesByProject(int projectId)   {
		List<Employee> listOfEmpProj = null;
		try {
			listOfEmpProj= taskService.getEmployeesByProject(projectId);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return listOfEmpProj;
	}

	@InitBinder
	public void bindDate(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "taskStartDate", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "taskEndDate", new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value = "/getTasks", method = RequestMethod.GET)
	@ResponseBody
	public List<ProjectTask> getTasks(Model model, HttpServletRequest request, HttpServletResponse response) throws ServiceException{
		int projectId = Integer.parseInt(request.getParameter("projectId")) ;
		List<ProjectTask> list = new ArrayList<ProjectTask>();
		if(projectId!=0){
			try {
				list = taskService.getTaskDetailsByProjectId(projectId);
			} catch (com.mindtree.exception.ServiceException e) {
				e.printStackTrace();
				try {
					response.sendRedirect("error.jsp");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}else{
			try {
				list = taskService.getAllProjectsTaskDetails();
			} catch (com.mindtree.exception.ServiceException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("projectTasks", list);
		
		return list;
	}
}
