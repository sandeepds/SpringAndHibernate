<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task Assignment</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script>
$( function() {
	 $("#taskstartdate").datepicker({dateFormat: 'dd-mm-yy',
		  minDate: 0,
		  onSelect: function(date) {
		    $("#taskenddate").datepicker('option', 'minDate', date);
		  }
		});

		$("#taskenddate").datepicker({dateFormat: 'dd-mm-yy',});
 } ); 
 </script>
 <script type="text/javascript">
	$(document).ready(function() {
		$("#project_id").change(function() {
			$.ajax({
				url : 'loadEmployeesList',
				method : 'get',
				ContentType : 'json',
				 data : {
					 projectId : $('#project_id').val()
			       },
				success : function(results) {

					var html = '<option selected="selected" value="-1" label="---SELECT---" />';
					if (results != null) {
						$(results).each(function(index, value) {
							html = html + '<option value="'+ value.empId +'">' + value.empName+" "+value.empId + '</option>';
						});
						$("#employee").html(html);
					}
				}
			});
		});
	});
	function validateEmp(){
		var value=document.getElementById("employee").value;
		alert(document.getElementById("employee").value);
		if(value==" "){
			alert("Please select a employee\ select a project");
			return false;
		}
		if(value==-1){
			alert("Please select a employee\ select a project");
			return false;
		}
	}
	
</script>
</head>
<body>
	<marquee><h2>Assign Tasks</h2></marquee>
	<br>
	
	<b><i>${successMsg}</i></b><br>	
	<br>
	 
	 <form:form  method="post"  modelAttribute="taskForm" action="addTask" onsubmit="return validateEmp()">
	 
	<table>
	<tbody>
		<tr>
		<td><label>Project</label></td>
		<td>
			<form:select path="projectId" id="project_id">
				<form:option value="0" label="--Select--"></form:option>
				<c:forEach items = "${projectlist}" var="temprojectlist">
					<form:option value="${temprojectlist.projectId}" label="${temprojectlist.projectId} - ${temprojectlist.projectName}"/>
				</c:forEach>
			</form:select>
		</td>
		</tr>
		
	
		<tr>
			<td><label>Description*</label></td>
			<td><form:input path="projectTaskDescription"/>
				<form:errors path="projectTaskDescription" cssClass="error"/>
			</td>
		</tr>
		<tr>
			<td><label>Start Date of Task [dd-mm-yyyy]*</label></td>
			<td><form:input path="taskStartDate" id="taskstartdate"/>
				<form:errors path="taskStartDate" cssClass="error"/>
			</td>
		</tr>
		<tr>
			<td><label>End Date of Task [dd-mm-yyyy]*</label></td>
			<td><form:input path="taskEndDate" id="taskenddate"/>
				<form:errors path="taskEndDate" cssClass="error"/>
			</td>
		</tr>
		<tr>
			<td><label>Who Should do this?*</label></td>
			<td><form:select path="listOfEmployees" id="employee" cols="20" rows="07" multiple="true">
			         <form:option selected="selected" value="-1" label="---SELECT---" />
				
			</form:select>
			</td>
		</tr>
		<tr>
			
			<td><input type="submit" value="Add Task"/></td>
		</tr>
		</tbody>
	</table>
	</form:form>
	
	<p>
			<a href="../index.jsp">Back to Main Menu</a>
		</p>
</body>
</html>