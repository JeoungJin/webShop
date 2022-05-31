package com.kosta.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet({ "/FirstServlet", "/first", "/first2.do", "/kosta/first3.do"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstServlet() {
        System.out.println("FirstServlet생성자 수행(최초요청시1회)");
    }
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet init수행(최초요청시1회)");
	}
	public void destroy() {
		System.out.println("FirstServlet destroy 수행(server중지시");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doGet수행(get요청시마다)");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<h1>get 요청 Served at:</h1> ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doPost 수행");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<h1>post요청  Served at: </h1>").append(request.getContextPath());
		
	}

}
