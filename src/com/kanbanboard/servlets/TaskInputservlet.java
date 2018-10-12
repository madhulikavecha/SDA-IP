package com.kanbanboard.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kanbanboard.beans.Project;
import com.kanbanboard.beans.Task;
import com.kanbanboard.dao.TaskInputDAO;

/**
 * Servlet implementation class TaskInputservlet
 */
@WebServlet("/TaskInputservlet")
public class TaskInputservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskInputservlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Task task = new Task();
		String taskName = request.getParameter("taskName");
		String taskStatus = request.getParameter("taskStatus");	
		String dueDate = request.getParameter("dueDate");
		String[] dueDateArray = dueDate.split("/");
		String month = dueDateArray[0];
		String date = dueDateArray[1];
		String year = dueDateArray[2];
		String sqlDate = year+"-"+month+"-"+date;

		task.setTaskName(taskName);
		task.setTaskStatus(taskStatus);
		task.setDueDate(java.sql.Date.valueOf(sqlDate));

		Project p = new Project();
		p.setProjectName(request.getParameter("projectName"));
		task.setP(p);

		TaskInputDAO taskInputDAOObj = new TaskInputDAO();

		boolean taskResult = taskInputDAOObj.createTasksDB(task);

		request.setAttribute("taskResultObj", taskResult);
		RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
		rd.forward(request, response);


	}

}
