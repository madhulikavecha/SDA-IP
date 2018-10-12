

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.kanbanboard.utility.DBConnection"%>
    <%ResultSet resultset =null;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Task</title>

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
  
  
</head>

<script language="javascript">
function validateFormsTasks() {
	var isTaskName = document.forms["taskForm"]["taskName"].value;
	
	
	if(isTaskName==""){
		document.getElementById('trackTaskName').innerHTML = 'please enter the task name';
		return false;
	}else if(/[^a-zA-Z0-9\s-]/.test(isTaskName)){
		document.getElementById('trackTaskNamespl').innerHTML='please enter valid task without special characters';
		return false;
	}
}
</script>

<body>
<center><font size ="5" style="color:green" > Welcome to To-Do Application </font><br/> </center>

<table>
<tr>
<td>
<%@ include file = "side.jsp" %>
</td>
<td>

<%
if(request.getAttribute("taskResultObj")!=null){
	boolean taskResult=(boolean)request.getAttribute("taskResultObj");
	if(taskResult==true){%>
	Your Task is successfully updated in kanban tool database
	<%taskResult=false;}
}
%>



<br/>
<form action="TaskInputservlet" method="post" name="taskForm"  onsubmit="return validateFormsTasks();">
Please add a new task : <input type="text" name="taskName" /> <br/>

<div id="trackTaskName" style="color:red">  </div>
<div id="trackTaskNamespl" style="color:red">  </div>

please select the task status :
<select name="taskStatus">
<option value="TO_DO"> TO DO </option>
<option value="STARTED"> STARTED </option>
<option value="IN_PROGRESS"> IN PROGRESS </option>
<option value="DONE"> DONE </option>
</select> <br/>

due date:
<input type="text" id="datepicker" name="dueDate" readonly="readonly"> <br/>


<% 
Connection connection = DBConnection.getConnection();
Statement statement = connection.createStatement();
resultset =statement.executeQuery("select * from Project");
%>
select project name:
<select name="projectName">
<%
while(resultset.next()){
%>
<option value="<%=resultset.getString("projectName")%>"><%=resultset.getString("projectName")%></option>
<%}%>
</select>

<input type="submit" value="Submit"/>
</form>

<br/><br/>

</td>
</tr>
</table>

</body>
</html>