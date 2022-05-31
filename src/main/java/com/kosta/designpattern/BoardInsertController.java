package com.kosta.designpattern;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.kosta.dto.BoardDTO;
import com.kosta.model.BoardService;
import com.kosta.util.UploadFileHelper;

public class BoardInsertController implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String method = request.getMethod();
		String page="";
		if(method.equals("GET")) {
			ServletContext app = request.getServletContext();
			String my = (String)app.getAttribute("myname");
			System.out.println("app에 저장된 정보:"  + my);
			
			page =  "boardInsert.jsp";
		}else {
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
			
			page= "redirect:boardlist.do";
		}
		
		return page;
	}

}
