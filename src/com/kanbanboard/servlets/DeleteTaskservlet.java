package com.kanbanboard.servlets;

import java.io.IOException;
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
 * Servlet implementation class DeleteTaskservlet
 */
@WebServlet("/DeleteTaskservlet")
public class DeleteTaskservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteTaskservlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		TaskInputDAO taskInputDAOObj1 = new TaskInputDAO();
		taskInputDAOObj1.removeTask(taskId);

		FilterInputDAO filterInputDAOObj = new FilterInputDAO();
		ArrayList<Task> tList=	filterInputDAOObj.getTasks("all",0);
		request.setAttribute("tListObj",tList);
		RequestDispatcher rd = request.getRequestDispatcher("/filter.jsp");
		rd.forward(request, response);

	}

}
