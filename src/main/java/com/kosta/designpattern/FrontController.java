package com.kosta.designpattern;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(uri);
		String page = "";
		Command command = null;
		if (uri.equals("/emp/emplist.do")) {
			command = new EmpListController();
		} else if (uri.equals("/emp/empInsert.do")) {
			command = new EmpInsertController();

		} else if (uri.equals("/emp/empDetail.do")) {
			command = new EmpDetailController();
		} else if (uri.equals("/emp/empDelete.do")) {
			command = new EmpDeleteController();
		} else if (uri.equals("/board/boardDelete.do")) {
			command = new BoardDeleteController();
		} else if (uri.equals("/board/boardDetail.do")) {
			command = new BoardDetailController();
		} else if (uri.equals("/board/boardUpdate.do")) {
			command = new BoardUpdateController();
		} else if (uri.equals("/board/boardInsert.do")) {
			command = new BoardInsertController();
		} else if (uri.equals("/board/boardlist.do")) {
			command = new BoardListController();
		}

		page = command.execute(request);
		if (page.indexOf("redirect:") >= 0) {
			page = page.substring(9);
			response.sendRedirect(page);

		} else if (page.indexOf("rest:") >= 0) {

		} else {
			RequestDispatcher rd;
			rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}

	}

}
