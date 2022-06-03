package com.kosta.designpattern;

import javax.servlet.http.HttpServletRequest;

import com.kosta.dto.BoardDTO;
import com.kosta.dto.DeptDTO;
import com.kosta.model.BoardService;
import com.kosta.model.DeptService;

public class DeptDetailController implements Command {

	@Override
	public String execute(HttpServletRequest request) {

		String deptid = request.getParameter("dept_id");
		System.out.println(deptid);
		
		int idept = Integer.parseInt(deptid);
		DeptService dService = new DeptService();
		DeptDTO dept = dService.selectById(idept);
		if(dept !=null) {
			request.setAttribute("deptname", dept.getDepartment_name());
			request.setAttribute("mid", dept.getManager_id());
			request.setAttribute("loc", dept.getLocation_id());
		}
		request.setAttribute("dept", dept);
		
		return "deptDetail.jsp" ;
	}

}
