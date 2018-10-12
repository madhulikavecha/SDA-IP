package com.kanbanboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kanbanboard.beans.Project;
import com.kanbanboard.utility.DBConnection;

/**
 * Class ProjectInputDAO - a DAO class in this dynamic web project.
 *
 * The class makes connection to database by creating an object of DBConnection class 
 * It contains the method to add a new project to the Project table
 * 
 * @author  Sudha Madhulika Vecha
 * @version 2018.10.12
 */

public class ProjectInputDAO {
 
	Project p = new Project();
	Connection con;
	boolean resultp=false;
	
	/*
	 * This method returns boolean value as true in case the project is added to the database else false
	 * Takes project name as input
	 * establish database connection
	 * execute SQL statement and update to the database 
	 * In case of an failure an SQL exception is thrown
	 */
	
	public boolean updateProjectDB(String projectName) {
		
		con =DBConnection.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("insert into Project(projectName) value(?)");
			ps.setString(1, projectName);
			int count=ps.executeUpdate();
			if(count>0) {
				resultp=true;
				p.setProjectName(projectName);
			}
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultp;
	}
}
