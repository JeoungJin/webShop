package com.shinhan.frontcontrollerpattern;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FontController
 */
@WebServlet("*.do")
public class FontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		
		//path = request.getRequestURI().substring(request.getContextPath().length());
		
		
		CommonControllerInterface controller = null;

		List<String> a = new LinkedList<>();

		Map<String, Object> data = new HashMap<>();
		data.put("method", request.getMethod());
		data.put("request", request);
		data.put("response", response);
		System.out.println(request.getServletPath() + " :ServletPath");

		switch (path) {
		case "/site-result/layout.do":
			controller = new LayoutTestController();
			break;
		case "/site-result/jobsAjax.do":
			controller = new JobsAjaxController();
			break;
		case "/site-result/picAjax.do":
			controller = new AdminPicAjaxController();
			break;
		case "/download.do":
			
			controller = new DownloadController();	break;
		case "/upload.do":
			controller = new UploadController();	break;
		case "/jstl.do":
			controller = new JSTLController();	break;
		case "/auth/loginCheck.do":
			controller = new LoginController();	break;
		case "/auth/logout.do":
			controller = new LogoutController();	break;
		case "/auth/signup.do":
			controller = new SignUpController();break;
		case "/auth/emailDupCheck.do":
			controller = new EmailDupCheckController();break;
		case "/emp/emplist.do":
			controller = new EmpListController();break;
		case "/emp/empDetail.do":
			controller = new EmpDetailController();break;
		case "/emp/empinsert.do":
			controller = new EmpInsertController();break;
		case "/emp/empDelete.do":
			controller = new EmpDeleteController();break;
		
		default:
			break;
		}
		String page = null;
		 
		try {
			page = controller.execute(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		if (page.indexOf("redirect:") >= 0) {
			response.sendRedirect(page.substring(9));
		}else if(page.indexOf("responseBody:")>=0) {
			response.setCharacterEncoding("utf-8");
			response.getWriter().append( page.substring(13));
		}else if(page.indexOf("download")>=0) {
			 
		}else {
			RequestDispatcher rd;
			rd = request.getRequestDispatcher(page);
			rd.forward(request, response);

		}
 
	}

}
