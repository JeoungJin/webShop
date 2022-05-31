package com.kosta.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.BoardDTO;
import com.kosta.model.BoardService;
import com.kosta.util.UploadFileHelper;

/**
 * Servlet implementation class BoardInsertServlet
 */
//@WebServlet("/board/boardInsert.do")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	//입력form보여주기 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	
	
		//ServletContext에 저장된 정보얻기
		
		ServletContext app = getServletContext();
		String my = (String)app.getAttribute("myname");
		System.out.println("app에 저장된 정보:"  + my);
		
	   RequestDispatcher rd;
	   rd = request.getRequestDispatcher("boardInsert.jsp");
	   rd.forward(request, response);
	}

	//입력된 data를 DB에 저장히기 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Filter로 처리함...request.setCharacterEncoding("utf-8");
		
		//String title = request.getParameter("title");
		//String content = request.getParameter("content");
		//int writer = Integer.parseInt(request.getParameter("writer"));
		//BoardDTO board = new BoardDTO(0, title, content, writer, null, null);	
		
		Map<String, Object> map = (Map<String, Object>)UploadFileHelper.uploadFile("uploads", request);
		List<String> fileNames = (List<String>)map.get("potos");
		Map<String, String> mapParam = (Map<String, String>)map.get("params");
		String pic = fileNames.get(0);
		BoardDTO board = new BoardDTO();
		for(String key:mapParam.keySet()) {
			if(key.equals("title")) board.setTitle(mapParam.get(key));
			if(key.equals("content")) board.setContent(mapParam.get(key));
			if(key.equals("writer")) board.setWriter(Integer.parseInt(mapParam.get(key)));
		}
		board.setPic(pic);
		System.out.println(board); 
		
		
		BoardService service = new BoardService();
		int result = service.insert(board);
		
		response.sendRedirect("boardlist.do");
		
		//Redirect : 주소창을 바꾼다 
		//forward : 요청주소창을 바꾸지않는다. 요청과 응답이 다른문서이다.  
		
		/*
		 * String message = "insert실패";
		if(result>0)  message = "insert성공";
		request.setAttribute("message", message);
		
		RequestDispatcher rd ;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);  */
	}

}






