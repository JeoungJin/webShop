package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.BoardDTO;
import com.kosta.model.BoardService;

/**
 * Servlet implementation class BoardUpdateServlet
 */
//@WebServlet("/board/boardUpdate.do")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Filter로 처리함...request.setCharacterEncoding("utf-8");
		int bno = Integer.parseInt( request.getParameter("bno") );
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDTO board = new BoardDTO(bno, title, content, 0, null, null);
		BoardService service = new BoardService();
		int result = service.update(board);
		String message = "수정실패";
		if(result>0)  message = "수정성공";
		request.setAttribute("message", message);
		RequestDispatcher rd ;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
		
	}

}
