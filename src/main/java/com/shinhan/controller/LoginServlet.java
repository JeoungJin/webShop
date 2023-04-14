package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.model.AdminService;
import com.shinhan.vo.AdminVO;

/**
 *http://localhost:9090/webShop 
 */
//@WebServlet({"/auth/loginCheck.do"})//URL mapping주소 정의
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	ServletContext app ;
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		  
		app = getServletContext();
		
		String DB_userid = app.getInitParameter("DB_userid");
    	System.out.println(DB_userid);  	
    	System.out.println(app.getInitParameter("DB_userid2" ));
		 
		
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
        //<input name="email">
		//<input name="pass"
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		AdminService service = new AdminService();
		AdminVO admin = service.loginCheck(email, pass);
		System.out.println(admin==null?"로그인실패":admin);
		
		Object obj = app.getAttribute("userList");
		List<AdminVO> userList = null;
		if(admin!=null) {
			if(obj == null) {
				userList = new ArrayList<>();
			}else {
				userList = (List<AdminVO>)obj;
			}
			userList.add(admin);
			app.setAttribute("userList", userList);
			System.out.println("-------로그인한사람 list----------------");
			for(AdminVO vo:userList) {
				System.out.println(vo);
		     }
			System.out.println("-----------------------");
		}
		//응답문서만들기  header + ResponseBody에 문자열을 출력하기 
		//<meta   charset="UTF-8">
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(admin==null) {
			//응답문서에 header부분을 작성해서 내려간다. 아래부분코드는 3초후 재요청한다는 의미이다. 
			//response.setHeader("refresh", "3;loginCheck.do" );
			response.addHeader("refresh", "3;loginCheck.do" );
			out.print("<h1 style='background-color:orange;'>Login Fail</h1>");
			return;
		}	
		//로그인한 사람의 정보를 저장하기 
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", admin);
		//ServletContext app = request.getServletContext();
		//app.setAttribute("loginUser", admin);
		
		//응답문서에 주소창을 바꾼다.(sendRedirect이용) 
		//http://localhost:9090/
		String path = request.getContextPath();
		String encodeName = URLEncoder.encode(admin.getManager_name(), "utf-8" );
		System.out.println(encodeName);
		response.sendRedirect(path + "/emp/emplist.do?myname="+encodeName);

		//재요청. 응답문서에 주소창을 바꾼다. (응답문서에 javascript를 가져간다)  
//		out.print("<script>"
//				+ "alert('로그인성공...업무화면으로 이동합니다.');"
//				+ "location.href='"
//				+ path
//				+ "/emp/emplist.do';"
//				+ "</script>");
		
		
	}
	

}





