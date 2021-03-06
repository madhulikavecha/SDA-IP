package com.kanbanboard.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kanbanboard.dao.ProjectInputDAO;

/**
 * Servlet implementation class ProjectInputservlet
 */
@WebServlet("/ProjectInputservlet")
public class ProjectInputservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjectInputservlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String projectName=request.getParameter("projectName");
		ProjectInputDAO projectInputDAO = new ProjectInputDAO();
		boolean projectResult = projectInputDAO.updateProjectDB(projectName);
		request.setAttribute("projectresult", projectResult);
		RequestDispatcher rd =request.getRequestDispatcher("/project.jsp");
		rd.forward(request, response);
	}

}
