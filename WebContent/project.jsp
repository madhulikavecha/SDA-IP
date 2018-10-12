<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Project</title>
<script language="javascript">
function validateFormsProjects() {
	var isProjectName=document.forms["projectForm"]["projectName"].value;
	if(isProjectName==""){
		document.getElementById('trackProjectName').innerHTML = 'please enter the project name';
		return false;
	}else if(/[^a-zA-Z0-9\s-]/.test(isProjectName)){
		document.getElementById('trackProjectNamespl').innerHTML='please enter valid projectname without special characters ';
		return false;
	}
}
</script>
</head>
<body>

<center><font size ="5" style="color:green" > Welcome to To-Do Application </font><br/> </center>
<table>
<tr>
<td>
<%@ include file = "side.jsp" %>
</td>

<td>
<br/><br/>
<%
if(request.getAttribute("projectresult")!=null){
	boolean p=(boolean)request.getAttribute("projectresult");
	if(p==true){%>
	<font style="color:blue" > Your project is successfully updated in kanban tool database. </font>
	<%p=false;} else {%>
	<font style="color:red" >A project with the same name already exists, please enter a different name. </font>
		<%	
	}
}
%>

<form action="ProjectInputservlet" method="post" name="projectForm" onsubmit="return validateFormsProjects();">
Please add project : <input type="text" name="projectName" /> <br/>

<div id="trackProjectName" style="color:red">  </div>
<div id="trackProjectNamespl" style="color:blue">  </div>

<input type="submit" value="Submit" />
</form>
</td>
</tr>



</body>
</html>