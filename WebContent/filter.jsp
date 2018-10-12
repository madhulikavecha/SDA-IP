<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kanbanboard.utility.DBConnection"  %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.kanbanboard.beans.Task" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
</script>

<body>
<center><font size ="5" style="color:green" > Welcome to To-Do Application </font><br/> </center>
 
 <table>
 <tr>
 <td>
 <%@ include file = "side.jsp" %>
 </td>
 
 <td>
 
 <form action="FilterInputservlet" method="post" name="filterByProject">

<%
Connection confilter =DBConnection.getConnection();
PreparedStatement ps = confilter.prepareStatement("select * from Project");
ResultSet rs=ps.executeQuery();
%>
Display all Tasks or Filter Tasks by Project name:
<select name="projectName">
<option value="all">All</option>
<%
while(rs.next()){	
%>
<option value="<%=rs.getString("projectName")%>"><%=rs.getString("projectName")%></option>
<%
}
%>
</select>

<input type="checkbox" style="color:blue" value="1" name="isSorted" > <b style="color:blue"> sortByTaskDueDate </b>

<input type="submit" value="submit">
</form>

<%
ArrayList<Task> taskObjList = new ArrayList<Task>();
Task task;
if(request.getAttribute("tListObj")!=null){
	taskObjList = (ArrayList<Task>) request.getAttribute("tListObj");
	Iterator<Task> it = taskObjList.iterator();
	%>
	
	</br>
	All task data of the selected project are exported to the file in the following location:</br>
	<b style="color:violet">/Users/tmp-sda-1187/eclipse-workspace/kanbanboard/WebContent/taskList.txt</b>
	
	</br></br>
	You may now edit/update the below tasks ....

    <table border=1>
    <tr><td><b>Task Id</b></td><td><b>Task Name</b></td><td><b>Task Status</b></td><td><b>Due Date</b></td><td><b>Project</b></td><td></td></tr>
	<% 
	while(it.hasNext()){
	    task = it.next();
	    int taskId = task.getTaskId();
	    String taskName = task.getTaskName();
	    String taskStatus = task.getTaskStatus();
	    java.sql.Date taskDate = task.getDueDate();
	    String projectName = task.getP().getProjectName();
	   
	    %>
	   
	<% String[] taskStatusArray = {"TO_DO", "STARTED", "IN_PROGRESS", "DONE"}; %>   
<tr>
<form action="EditedTaskInputservlet" method="post"> 
<td><input type=text name="taskId" value="<%=taskId%>" hidden="hidden"><%=taskId%></td>
<td>
<input type=text name="taskName" value="<%=taskName%>">

</td> 

<td>

<select name="taskStatus">

<%for(int i=0;i<4;i++){ 
if(!taskStatusArray[i].equalsIgnoreCase(taskStatus)){
%>
<option value="<%=taskStatusArray[i] %>"> <%=taskStatusArray[i] %> </option>
<%}else{ %>
	
	<option value="<%=taskStatusArray[i] %>" selected = "selected"> <%=taskStatusArray[i] %> </option> 
<%}} %>

</select>

</td> 

<td><input type="text" name="dueDate" value="<%=taskDate%>" ></td> 
<td><input type="text" name="projectName" value="<%=projectName%>" hidden="hidden"><%=projectName%></td> 
<td><input type="submit" value="submit updated task"></td>

</form>

<td>
<form name="deleteForm" action="DeleteTaskservlet" method="post">

<input type=text name="taskId" value="<%=taskId%>" hidden="hidden">
<input type="submit" value="Delete Task"/>
</form>
</td>

</tr>
	   <% }%>
	</table>
<% }%>
 
 </td>
 </tr>
 </table>
 
 



</body>
</html>