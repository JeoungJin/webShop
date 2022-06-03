package com.kosta.designpattern;

import javax.servlet.http.HttpServletRequest;

import com.kosta.model.DeptService;

public class DeptListController implements Command {

	@Override
	public String execute(HttpServletRequest request) {

		DeptService service = new DeptService();
		request.setAttribute("deptlist", service.selectAll());

		return "deptList.jsp";
	}

}
