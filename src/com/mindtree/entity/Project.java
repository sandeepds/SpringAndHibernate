package com.mindtree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;

@Entity
@Table(name="PROJECT")
public class Project {

	static Logger logger = Logger.getLogger(Project.class.getName());
	
	@Id
	@Column(name="PROJECT_ID")
	Integer projectId;
	
	@Column(name="PROJECT_NAME")
	String projectName;
	
	public Project()
	{
		
	}

	public Project(String projectName) {
		
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "Projects [projectId=" + projectId + ", projectName=" + projectName + "]";
	}

	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
			
}
