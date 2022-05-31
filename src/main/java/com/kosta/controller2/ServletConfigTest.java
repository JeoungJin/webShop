package com.kosta.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * URL default
 * http://localhost:9090/webShop
 */
/*
 * @WebServlet( urlPatterns = { "/ServletConfigTest", "/config1", "/config2" },
 * initParams = {
 * 
 * @WebInitParam(name = "myphone", value = "010-1234-5678"),
 * 
 * @WebInitParam(name = "myaddress", value = "서울시 노원구") })
 */
public class ServletConfigTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ServletConfigTest() {
    	System.out.println("ServletConfigTest 생성자");
    }
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	

		String myphone = getInitParameter("myphone");
		String myaddress = getInitParameter("myaddress");
		System.out.println("myphone" + myphone);
		System.out.println("myaddress" + myaddress);
	
	}

}
