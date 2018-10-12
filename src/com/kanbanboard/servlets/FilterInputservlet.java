package com.kanbanboard.servlets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kanbanboard.beans.Task;
import com.kanbanboard.bo.ExportDataToFile;
import com.kanbanboard.dao.FilterInputDAO;

/**
 * Servlet implementation class FilterInputservlet
 */
@WebServlet("/FilterInputservlet")
public class FilterInputservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FilterInputservlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pName= request.getParameter("projectName");
		FilterInputDAO filterInputDAOObj = new FilterInputDAO();

		String[] isSortedValues = request.getParameterValues("isSorted");
		int isSorted=0;
		if(isSortedValues!=null) {
			isSorted=Integer.parseInt(isSortedValues[0]);
		}

		ArrayList<Task> tList=	filterInputDAOObj.getTasks(pName, isSorted);
		request.setAttribute("tListObj",tList);

		ExportDataToFile exportDataToFileObj = new ExportDataToFile();
		exportDataToFileObj.exportData(tList);

		RequestDispatcher rd = request.getRequestDispatcher("/filter.jsp");
		rd.forward(request, response);

	}

}
