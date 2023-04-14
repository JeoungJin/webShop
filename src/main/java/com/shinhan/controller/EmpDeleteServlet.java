package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.EmpService;

/**
 * Servlet implementation class EmpDeleteServlet
 */
//@WebServlet("/emp/empDelete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		
		EmpService service = new EmpService();
		service.empDelete(empid);
		//요청재지정 
		response.sendRedirect("emplist.do");
	
	}

}





