package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/html/login2.do")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
        //get요청은 주소창에 파라메터가 자동으로 인코딩되어 넘어온다. 한글깨짐없음 
		//post요청은 요청문서의 body에 파라메터가 인코딩안되어 넘어온다. 한글깨짐 
         request.setCharacterEncoding("utf-8");//post에서만 필요 
		 String id = request.getParameter("a");
         String pass = request.getParameter("b");
         String email = request.getParameter("c");
         String address = request.getParameter("d");
         System.out.println(id);
         System.out.println(pass);
         System.out.println("email=" + email);
         System.out.println("address=" + address);
         System.out.println(request.getMethod());
         System.out.println(request.getContextPath());
         
          
         
         
	}

	 

}
