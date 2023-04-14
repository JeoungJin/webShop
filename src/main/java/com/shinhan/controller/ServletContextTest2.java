package com.shinhan.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.vo.EmpVO;


@WebServlet("/get")
public class ServletContextTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		//ServletContext=>application에 저장하기 
		ServletContext app = request.getServletContext();
		int score = (Integer)app.getAttribute("score");
		String name = (String)app.getAttribute("studentname");
		EmpVO emp = (EmpVO)app.getAttribute("empinfo");
		
		System.out.println(score);
		System.out.println(name);
		System.out.println(emp);
		
		String realPath = app.getRealPath(".");
		System.out.println(realPath);
		
		
		String id = app.getInitParameter("DB_userid");
		String pass = app.getInitParameter("DB_userpass");
		System.out.println(id + "----" + pass);
		
		
		
		
		System.out.println(realPath + "/WEB-INF/resource/dbinfo.txt");
		
		
		InputStream is = app.getResourceAsStream( "/WEB-INF/resource/dbinfo.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String s;
		
		while((s = br.readLine())!=null) {
			System.out.println(s);
		}
		br.close();
		
	}

	 
}






