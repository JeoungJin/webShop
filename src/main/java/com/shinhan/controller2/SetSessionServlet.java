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
@WebServlet("/SetSessionServlet")
public class SetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String userpass = request.getParameter("userpass");
		
		HttpSession session = request.getSession();//최초접속인경우 Session없음, 자동생성한다.(true)
		System.out.println(session.getId());//
		System.out.println(session.getMaxInactiveInterval());//30분
		System.out.println(session.isNew());
		
		session.setAttribute("key1", userid);
		session.setAttribute("key2", 100);
		session.setAttribute("key3", new AdminVO("zzilre@aa.com","진","1234"));
		
		
		
		response.setContentType("text/html;charset=utf-8");//<meta charset="utf-8">
		PrintWriter out = response.getWriter();
		out.write("<h1>Session저장연습</h1>");
	
	
	}

	 

}





