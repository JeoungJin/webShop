package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.vo.EmpVO;


@WebServlet("/set")
public class ServletContextTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		//ServletContext=>application에 저장하기 
		ServletContext app = request.getServletContext();
		app.setAttribute("score", 100);
		app.setAttribute("studentname", "경윤");
		EmpVO emp = new EmpVO();
		emp.setFirst_name("스티븐");
		emp.setSalary(24000);
		app.setAttribute("empinfo", emp);
		
		System.out.println(emp);
		
	}

	 
}






