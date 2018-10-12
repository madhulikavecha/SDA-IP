<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>


<center>
<font size ="5" style="color:green" > Welcome to To-Do Application </font><br/> 
 
<%
ResultSet rsTaskStatus=null;
Connection conDB =DBConnection.getConnection();
Statement statement_todo=conDB.createStatement();
rsTaskStatus=statement_todo.executeQuery("select count(*) from Tasks where taskStatus='To_Do';");

while(rsTaskStatus.next()){
	String count = rsTaskStatus.getString(1);
	out.println("No of tasks are in To-Do : " +count);
}
%>
<br/>
<%

Statement statement_done=conDB.createStatement();
rsTaskStatus=statement_done.executeQuery("select count(*) from Tasks where taskStatus='Done';");

while(rsTaskStatus.next()){
	String count = rsTaskStatus.getString(1);
	out.println("No of tasks are Done : " +count);
}
%>

<table>
<tr>
<td>
<%@ include file = "side.jsp" %>
</td>
<td>

</td>
</tr>
</table>
</center>

</body>
</html>

