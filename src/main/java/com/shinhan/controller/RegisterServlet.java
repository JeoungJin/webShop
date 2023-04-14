package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.AdminService;
import com.shinhan.vo.AdminVO;

/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet("/auth/signup.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doPost(HttpServletRequest request,
   			HttpServletResponse response) throws ServletException, IOException {
 
   	    //get방식은 parameter가 넘어올때 URL에 encoding되어들어온다. %ㅍㅊㅍㅎㄹ%ㅠ픂
   		//post방식은 parameter가 넘어올때 요청문서의 body에 들어온다. 한글이깨짐
   		request.setCharacterEncoding("utf-8");
   		
   		String mname = request.getParameter("manager_name");
 
   		System.out.println(mname);
   		String email = request.getParameter("email");
   		String pass = request.getParameter("pass");
   		AdminVO vo = new AdminVO(email, mname, pass);
   		AdminService service = new AdminService();
   		int result = service.registerAdmin(vo);
 
   		response.setContentType("text/html;charset=utf-8");
   		PrintWriter out = response.getWriter(); //응답문서의 body부분에 출력된다.
   		if(result==1) {
   			out.print("<h1>계정등록 성공</h1>");
   			//직원조회 페이지로 이동 ....
   		}else {
   			out.print("<h1>계정등록 실패</h1>");
   			
   		}
   		response.addHeader("refresh", "1;login.jsp");
	}

}







