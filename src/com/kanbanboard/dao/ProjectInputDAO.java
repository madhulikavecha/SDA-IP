package com.kanbanboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.kanbanboard.utility.DBConnection;

public class ProjectInputDAO {

	Connection con;
	Statement st=null;
	boolean resultp=false;
	
	public boolean updateProjectDB(String projectName) {
		con =DBConnection.getConnection();
		try {
			st=con.createStatement();
		} catch (SQLException e) {
			System.out.println("no connection established");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement ps= con.prepareStatement("insert into Project(projectName) value(?)");
			ps.setString(1, projectName);
			int count=ps.executeUpdate();
			if(count>0) {
				resultp=true;
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
