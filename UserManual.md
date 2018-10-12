
#TO-DO USER MANUAL


Project :  To-Do List Application
Author : Sudha Madhulika Vecha
Date   : 12-10-2018

#PROJECT OVERVIEW
This is a dynamic web project built on MVC architecture. In this version, the user can add new projects and also add numerous tasks in each project. The user can also retrieve the information from the database and add/modify the data as necessary. MySQL is used as the backend in the project.

#TO RUN PROJECT 
To run the project, Select the project, right click and Run As --> Run on Server --> Select Apache Tomcat v9.0 version


The user can filter the task based on project and sort by due date accordingly.

Upon selecting the project, all the data will be exported and written to a file called taskList.txt. The taskList.txt template is pre-saved in WebContent.

In the Main page, user can also see how many tasks are in TO-DO state and DONE state.

#VERSIONS USED
IDE: Eclipse Photon
Server: Apache Tomcat v9.0
MySQL: MySql 8.0.12

To setup a connection to MySql JDBC driver is used and the connection is setup from DBConnection.java in utility package.
Where the DB connetion is required, an object DBConnection is created.

#PROJECT DESCRIPTION 
In the index.jsp , you have several links to add a project, add a task, edit/delete/export a task or to return homepage as
per user requirement

On click of Add Project hyperlink, user can add a project to the database. 
On click of submit button, the action reaches to ProjectInputServlet where a ProjectInputDAO object is created to establish a connection to the database. Once the connection is established, the user written project name value will be updated to the database successfully. If user enters the same project name multiple times, user gets a prompt to add a different project name

On click of Add Task hyperlink, user can add a task to the database. 
On click of submit button, the action reaches to TaskInputServlet where a TaskInputDAO object is created to establish a connection to the database. Once the connection is established, the user written task name value will be updated to the database successfully. If user enters invalid input, client side validations will be done and the user will get a prompt to enter a valid values with possible hints.

On click of Edit/Delete/Export Tasks hyperlink, user can Edit/Delete a task in the database and also able to export the task list to a file. The user can select from which project the task records needs to be displayed or by default the tasks from all projects are displayed. User also has an option to sort the tasks by due date. On click of submit button, the action reaches to FilterInputServlet where a FilterInputDAO object is created to establish a connection to the database. Once the connection is established, all the tasks from the user selected project will be retrieved and displayed on the user interface. Once the tasks are displayed, the user can either edit/delete the task from database.

On click of Return Home Page hyperlink, user returns to the home page where the information about how many records are in TO-DO state or DONE state will be displayed.

#CLASS DIAGRAM
Class diagram is located in classdiagram.jpg in the images folder of WebContent directory