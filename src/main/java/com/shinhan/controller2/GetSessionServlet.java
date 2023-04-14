package com.shinhan.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.vo.AdminVO;

/**
 * Servlet implementation class SetSessionServlet
 */
@WebServlet("/GetSessionServlet")
public class GetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session = request.getSession(false);//요청에의해 sessionid를 가져온다, 
		System.out.println(session);
		if(session==null) return;
		
		System.out.println(session.getId());//
		System.out.println(session.getMaxInactiveInterval());//30분
		System.out.println(session.isNew());
		
		
		
		String userid = (String)session.getAttribute("key1" );
		int score = (Integer)session.getAttribute("key2" );
		AdminVO admin = (AdminVO)session.getAttribute("key3" );
		
		
		
		response.setContentType("text/html;charset=utf-8");//<meta charset="utf-8">
		PrintWriter out = response.getWriter();
		out.write("<h1>Session읽기연습</h1>");
	
	
	}

	 

}





