package com.shinhan.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTestServlet
 */
@WebServlet("/aa/bb/requestTest/*")
public class RequestTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		System.out.println("========요청정보 얻기 ============");
		//Header + Body
		System.out.println("getContextPath:" + request.getContextPath());
		System.out.println("getMethod:" + request.getMethod());
		System.out.println("getRequestURI:" + request.getRequestURI());
		System.out.println("getLocalPort:" + request.getLocalPort());
		System.out.println("getLocalAddr:" + request.getLocalAddr());
		System.out.println("getRemoteAddr:" + request.getRemoteAddr());
		System.out.println("getServletPath:" + request.getServletPath());
		System.out.println("getPathInfo:" + request.getPathInfo());
		
		//요청한 Browser의 정보 : user-agent
		Enumeration<String> hs = request.getHeaderNames();
		while(hs.hasMoreElements()) {
			String name = hs.nextElement();
			System.out.println("headerName:" + name);
			System.out.println(request.getHeader(name));
			System.out.println("---------------------");
		}
		response.getWriter().append("(jin)......Served at: ").append(request.getContextPath());
	}
}
