package com.kosta.designpattern;

import javax.servlet.http.HttpServletRequest;

import com.kosta.model.DeptService;

public class DeptDeleteController implements Command{

	@Override
	public String execute(HttpServletRequest request) {
		int deptid = Integer.parseInt(request.getParameter("deptid"));
        
        DeptService service = new DeptService();
        int result =  service.deptDelete(deptid);
        request.setAttribute("message", result>0?"삭제성공":"삭제실패");
        return "redirect:deptlist.do";
	}

}
