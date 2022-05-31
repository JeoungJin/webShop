package com.kosta.designpattern;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kosta.dto.BoardDTO;
import com.kosta.model.BoardService;

public class BoardListController implements Command {

	@Override
	public String execute(HttpServletRequest request) {

		BoardService service = new BoardService();
		List<BoardDTO> blist = service.selectAll();
		
		request.setAttribute("boardDatas", blist);
		request.setAttribute("boardSize", blist.size());
		 
		return "boardList.jsp";
	}

}
