package com.shinhan.frontcontrollerpattern;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shinhan.model.EmpService;

public class EmpDeleteController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		HttpServletRequest request = (HttpServletRequest)data.get("request");
		int empid = Integer.parseInt(request.getParameter("empid"));
		
		EmpService service = new EmpService();
		String message = service.empDelete(empid);
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		//요청재지정 
		return "redirect:emplist.do";
	}

}
