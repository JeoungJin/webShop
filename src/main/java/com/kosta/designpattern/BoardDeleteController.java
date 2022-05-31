package com.kosta.designpattern;

import javax.servlet.http.HttpServletRequest;

import com.kosta.model.BoardService;

public class BoardDeleteController implements Command {

	@Override
	public String execute(HttpServletRequest request) {

		int bno = Integer.parseInt(request.getParameter("bno"));

		BoardService service = new BoardService();
		int result = service.delete(bno);
		request.setAttribute("message", result > 0 ? "삭제성공" : "삭제실패");
		return "result.jsp";
	}

}
