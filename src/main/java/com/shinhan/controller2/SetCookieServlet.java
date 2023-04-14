package com.shinhan.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieServlet
 */
@WebServlet("/setcookie")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		//쿠키를 만들어서 응답문서에 추가한다...이 요청이 끝나고 나서도 정보를 유지하고자한다.  
		String userid = request.getParameter("userid");
		String userpass = request.getParameter("userpass");
		
		response.setContentType("text/html;charset=utf-8");//<meta charset="utf-8">
		PrintWriter out = response.getWriter();
		out.write("<h1>쿠키저장연습</h1>");
		
		Cookie c1 = new Cookie("userid", userid);
		c1.setMaxAge(60*10);//10분
		Cookie c2 = new Cookie("userpass", userpass);
		c2.setMaxAge(60);//1분
		
		response.addCookie(c1);
		response.addCookie(c2);
		
		
 	}

	 

}






