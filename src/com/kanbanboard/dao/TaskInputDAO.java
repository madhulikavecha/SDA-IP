package com.kanbanboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kanbanboard.beans.Task;
import com.kanbanboard.utility.DBConnection;

public class TaskInputDAO {

	Connection conn;
	Statement st=null;
	boolean result=false;
	
	public boolean updateTasksDB(Task task) {
		
		conn = DBConnection.getConnection();
		
		try {
			st = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("insert into Tasks (taskName,dueDate,taskStatus,projectName) values(?,?,?,?)");
			ps.setString(1, task.getTaskName());
			ps.setDate(2, java.sql.Date.valueOf("2018-09-25"));
			ps.setString(3, task.getTaskStatus());
			ps.setString(4, task.getP().getProjectName());
			int executeCount = ps.executeUpdate();
			if(executeCount>0) {
				result=true;
			}
			System.out.println("result value"+result);
		}
		
		catch (SQLException sqle) {
			
		}
		
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
}
