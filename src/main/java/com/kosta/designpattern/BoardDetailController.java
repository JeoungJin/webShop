package com.kosta.designpattern;

import javax.servlet.http.HttpServletRequest;

import com.kosta.dto.BoardDTO;
import com.kosta.model.BoardService;

public class BoardDetailController implements Command {

	@Override
	public String execute(HttpServletRequest request) {

		String s_boardid = request.getParameter("boardid");
		int i_board = Integer.parseInt(s_boardid);

		BoardService bService = new BoardService();
		BoardDTO board = bService.selectById(i_board);
		request.setAttribute("board", board);

		return "boardDetail.jsp" ;
	}

}
