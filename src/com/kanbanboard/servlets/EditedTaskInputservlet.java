package com.kanbanboard.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kanbanboard.beans.Task;
import com.kanbanboard.dao.FilterInputDAO;
import com.kanbanboard.dao.TaskInputDAO;

/**
 * Servlet implementation class EditedTaskInputservlet
 */
@WebServlet("/EditedTaskInputservlet")
public class EditedTaskInputservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditedTaskInputservlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Task task = new Task();
		String taskName=request.getParameter("taskName");
		String taskStatus=request.getParameter("taskStatus");
		Date dueDate = java.sql.Date.valueOf(request.getParameter("dueDate"));
		int taskId=Integer.parseInt(request.getParameter("taskId"));

		task.setTaskName(taskName);
		task.setTaskStatus(taskStatus);
		task.setDueDate(dueDate);
		task.setTaskId(taskId);

		TaskInputDAO taskInputdao = new TaskInputDAO();
		taskInputdao.updateTask(task);

		FilterInputDAO filterInputDAOObj = new FilterInputDAO();
		ArrayList<Task> tList=	filterInputDAOObj.getTasks("all",0);
		request.setAttribute("tListObj",tList);
		RequestDispatcher rd = request.getRequestDispatcher("/filter.jsp");
		rd.forward(request, response);
	}
}
