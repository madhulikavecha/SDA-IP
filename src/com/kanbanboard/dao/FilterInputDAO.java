package com.kanbanboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import com.kanbanboard.beans.Project;
import com.kanbanboard.beans.Task;
import com.kanbanboard.utility.DBConnection;

/**
 * Class FilterInputDAO - a DAO class in this dynamic web project.
 *
 * The class makes connection to database by creating an object of DBConnection class 
 * It contains the method to return the tasks list from the database
 * In case of an failure an SQL exception is thrown
 * 
 * @author  Sudha Madhulika Vecha
 * @version 2018.10.12
 */

public class FilterInputDAO {
	ArrayList<Task> taskList = new ArrayList<Task>();

	/* getTasks method fetch the data from database
	 * The method takes project Name and isSorted as input arguments 
	 * All the tasks data can be fetched and also the tasks related to a specific project can be fetched
	 * all the data is added to an Arraylist the same is returned by this method
	 * User can also select if the data needs to displayed in sorted date order
	 * 
	 */

	public ArrayList<Task> getTasks(String pName, int isSorted) {
		Task task;
		Project project;
		System.out.println("pname is"+pName);
		PreparedStatement ps;
		Connection con = DBConnection.getConnection();
		try {
			if(!pName.equals("all")) {
				ps= con.prepareStatement("select * from Tasks where projectName='"+pName+"';");
			} else {
				ps= con.prepareStatement("select * from Tasks;");
			}

			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				task = new Task();
				project = new Project();
				task.setTaskId(rs.getInt("taskId"));
				task.setTaskName(rs.getString("taskName"));
				task.setDueDate(rs.getDate("dueDate"));
				task.setTaskStatus(rs.getString("taskStatus"));
				project.setProjectName(rs.getString("projectName"));
				task.setP(project);
				taskList.add(task);
				System.out.println(task.getDueDate());

			}

			if(isSorted==1) {
				Collections.sort((ArrayList<Task>) taskList);
			}

			Iterator<Task> it = taskList.iterator();
			System.out.println("displaying in sorted");
			while(it.hasNext()) {
				System.out.println(it.next().getDueDate());
			}



		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(taskList.size());
		return taskList;

	}

}
