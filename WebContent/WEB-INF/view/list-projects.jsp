<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projects list</title>
</head>
<body>
	<%-- <form:form  method="GET">
		Below are the project details:<br><br>
		
		<!-- loop over the projects and print -->
		Projects:
		<form:select>
			<form:option value="" label="---SELECT---" />
			<c:forEach items="${projectlist}" var="temprojectlist">
				<form:option value="${temprojectlist.projectId}  ${temprojectlist.projectName}">
				
				</form:option>
				
				<br>
				<br>
			</c:forEach>
		</form:select>
			
	</form:form> --%>
	<%-- <select>
			<option value="" label="---SELECT---" />
			<c:forEach items="${projectlist}" var="temprojectlist">
				<option value="${temprojectlist.projectId}  ${temprojectlist.projectName}" label="${temprojectlist.projectId}  ${temprojectlist.projectName}"/>
			</c:forEach>
	</select> --%>
	<form:form modelAttribute="projectTask" method="POST" action="/saveTask">
		<form:select path="project.projectId">
			<form:option value="0" label="--Select--"></form:option>
			<c:forEach items = "${projectlist}" var="temprojectlist">
				<form:option value="${temprojectlist.projectId}" label="${temprojectlist.projectId} - ${temprojectlist.projectName}"/>
			</c:forEach>
		</form:select>
	</form:form>
</body>
</html>