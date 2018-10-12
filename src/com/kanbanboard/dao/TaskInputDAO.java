package com.kanbanboard.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.kanbanboard.beans.Task;
import com.kanbanboard.utility.DBConnection;

/**
 * Class TaskInputDAO - a DAO class in this dynamic web project.
 *
 * The class makes connection to database by creating an object of DBConnection class 
 * It contains the methods to add/remove/update tasks to the Tasks table
 * 
 * @author  Sudha Madhulika Vecha
 * @version 2018.10.12
 */

public class TaskInputDAO {

	Connection conn;
	Statement st=null;
	boolean result=false;

	/* This method returns boolean value as true if the task in inserted successfully else false
	 * Takes task class object as input
	 * Establish database connection
	 * execute sql query to insert data 
	 * update the database or send exception in case of a failure
	 */
	
	public boolean createTasksDB(Task task) {

		conn = DBConnection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement("insert into Tasks (taskName,dueDate,taskStatus,projectName) values(?,?,?,?)");
			ps.setString(1, task.getTaskName());
			ps.setDate(2, task.getDueDate());
			ps.setString(3, task.getTaskStatus());
			ps.setString(4, task.getP().getProjectName());
			int executeCount = ps.executeUpdate();
			if(executeCount>0) {
				result=true;
			}
		}

		catch (SQLException sqle) {

		}

		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}


	/* This method does not return anything
	 * Takes task Id as an input
	 * Establish database connection
	 * execute sql query to remove task data 
	 * update the database or send exception in case of a failure
	 */
	
	public void removeTask(int taskId) {
		conn=DBConnection.getConnection();
		try {
			String sql ="delete from Tasks where taskId='"+taskId+"'; ";
			PreparedStatement ps1=conn.prepareStatement(sql);
			ps1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/* This method does not return anything
	 * Takes task object as an input
	 * Establish database connection
	 * execute sql query to update task data 
	 * update the database or send exception in case of a failure
	 */
	
	public void updateTask(Task task) {
		conn = DBConnection.getConnection();
		try {
			String taskName=task.getTaskName();
			String taskStatus=task.getTaskStatus();
			Date dueDate=task.getDueDate();
			int taskId=task.getTaskId();
			String sql="update Tasks set taskName='"+taskName+"',taskStatus='"+taskStatus+"',dueDate='"+dueDate+"' where taskId='"+taskId+"'";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
