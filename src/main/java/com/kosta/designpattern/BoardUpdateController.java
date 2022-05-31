package com.kosta.designpattern;

import javax.servlet.http.HttpServletRequest;

import com.kosta.dto.BoardDTO;
import com.kosta.model.BoardService;

public class BoardUpdateController implements Command {

	@Override
	public String execute(HttpServletRequest request) {

		int bno = Integer.parseInt( request.getParameter("bno") );
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDTO board = new BoardDTO(bno, title, content, 0, null, null);
		BoardService service = new BoardService();
		int result = service.update(board);
		String message = "수정실패";
		if(result>0)  message = "수정성공";
		request.setAttribute("message", message);
		return "result.jsp";
	}

}
