package com.kosta.designpattern;

import javax.servlet.http.HttpServletRequest;

import com.kosta.model.EmpService;

public class EmpDeleteController implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		 
		int empid = Integer.parseInt(request.getParameter("emp_id"));

		EmpService service = new EmpService();
		int result = service.empDelete(empid);
		request.setAttribute("message", result > 0 ? "삭제성공" : "삭제실패");
		return "redirect:emplist.do";
	}

	 
}
