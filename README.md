
#TO-DO


Project :  To-Do List Application
Author : Sudha Madhulika Vecha
Date   : 12-10-2018


This is a dynamic web project built on MVC architecture. In this version, the user can add new projects and also add numerous tasks in each project. The user can also retrieve the information from the database and add/modify the data as necessary. MySQL is used as the backend in the project.

The user can filter the task based on project and sort by due date accordingly.

Upon selecting the project, all the data will be exported and written to a file called taskList.txt. The taskList.txt template is pre-saved in WebContent.

In the Main page, user can also see how many tasks are in TO-DO state and DONE state.

To run the project, Select the project, right click and Run As --> Run on Server --> Select Apache Tomcat v9.0 version

Class diagram is located in classdiagram.jpg in the images folder of WebContent directory


Versions Used

IDE: Eclipse Photon
Server: Apache Tomcat v9.0
MySQL: MySql 8.0.12


To setup a connection to MySql JDBC driver is used and the connection is setup from DBConnection.java in utility package.
Where the DB connetion is required, an object DBConnection is created.
