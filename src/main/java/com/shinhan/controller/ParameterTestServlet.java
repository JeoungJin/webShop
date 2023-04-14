package com.shinhan.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterTestServlet
 */
@WebServlet("/param")
public class ParameterTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String salary = request.getParameter("salary");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String param = paramNames.nextElement();
			if(param.equals("hobby")) {
				String[] value = request.getParameterValues(param);
				System.out.println(param + "---" + Arrays.toString(value));
			}else {
				String value = request.getParameter(param);
				System.out.println(param + "---" + value);
			}
			
		}
		System.out.println("----------------------");
		
		System.out.println("userid:" + userid);
		System.out.println("salary:" + salary);
		System.out.println("gender:" + gender);
		System.out.println("hobby:" + Arrays.toString(hobby));
	}

 
}
