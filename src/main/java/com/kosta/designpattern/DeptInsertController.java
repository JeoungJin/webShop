package com.kosta.designpattern;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.kosta.dto.BoardDTO;
import com.kosta.dto.DeptDTO;
import com.kosta.model.BoardService;
import com.kosta.model.DeptService;
import com.kosta.util.UploadFileHelper;

public class DeptInsertController implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String method = request.getMethod();
		String page = "";
		if (method.equals("GET")) {

			page = "deptInsert.jsp";
		} else {

			int department_id = Integer.parseInt(request.getParameter("department_id"));
			int manager_id = Integer.parseInt(request.getParameter("manager_id"));
			int location_id = Integer.parseInt(request.getParameter("location_id"));
			String department_name = request.getParameter("department_name");
			DeptDTO dept = new DeptDTO(department_id, department_name, manager_id, location_id);
			DeptService service = new DeptService();

			request.setAttribute("message", service.deptInsert(dept) > 0 ? "insert성공" : "insert실패");

			page = "redirect:deptlist.do";
		}

		return page;
	}

}
