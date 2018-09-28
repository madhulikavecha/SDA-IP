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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		Task task = new Task();
		String taskName = request.getParameter("taskName");
		String taskStatus = request.getParameter("taskStatus");		
		
		task.setTaskName(taskName);
		task.setTaskStatus(taskStatus);
		
		Project p = new Project();
		p.setProjectName(request.getParameter("projectName"));
		task.setP(p);
		
		TaskInputDAO taskInputDAOObj = new TaskInputDAO();
		boolean taskResult = taskInputDAOObj.updateTasksDB(task);
		
		request.setAttribute("taskResultObj", taskResult);
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		
	//	response.sendRedirect("index.jsp"); 
		
	}

}
