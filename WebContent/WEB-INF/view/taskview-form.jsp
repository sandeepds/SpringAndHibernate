<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<link rel="stylesheet"	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">

$(document).ready(function() {
	$("#project_id").change(function() {
		$("#tableData").html("");
		$.ajax({
			url : 'getTasks',
			method : 'get',
			ContentType : 'json',
			data : {
				projectId : $('#project_id').val()
				}, success : function(results) {
					
					var table = "";
					$.each(results, function(index, value){
						
						table += "<br>Project:" + value.project.projectName + "<br>";
						table += "Task Description:" + value.projectTaskDescription + "<br>";
						table += "Task Start Date:" + value.startDate + "<br>";
						table += "Task End Date:" + value.endDate + "<br>";
						
						table += "<table border = '2'><tr><th>MID</th><th>Emp Name</th></tr>";
						$.each(value.listOfEmployees, function(j, employee){
							table += "<tr><td>"+employee.empId+"</td><td>"+employee.empName+"</td></tr>"; 
						});
						table += "<table>";
					});
					$("#tableData").html(table);
				}
			});
		});
	});
</script>

<title>Task Viewer</title>
</head>
<body>
<div>
<marquee><h2>View Tasks</h2></marquee>

<table>
	<tbody>
		<tr>
		<td><label>Filter by Project</label></td>
		<td>
			<form:select path="project.projectId" id="project_id">
				<form:option value="" label="---SELECT---" />
				<form:option value="0" label="  All Projects  " />
				<c:forEach items = "${projectList}" var="temprojectlist">
					<form:option value="${temprojectlist.projectId}">
					<c:out value="${temprojectlist.projectName}"></c:out>
					</form:option>
				</c:forEach>
			</form:select>
		</td>
		</tr>
	</tbody>
</table>

<div id = "tableData"></div>
</div>
<div style="display: block" id="dataView">
	<c:forEach items="${projectTasks}" var="projTask">
		<p>${projTask.projectTaskId}</p>
			</c:forEach>
</div>
<p>
	<a href="../index.jsp">Back to Main Menu</a>
</p>
</body>
</html>