package com.shinhan.frontcontrollerpattern;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.shinhan.model.AdminService;

public class EmailDupCheckController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		
		HttpServletRequest request = (HttpServletRequest)data.get("request");
		
		String email = request.getParameter("email");
		System.out.println(email);
		AdminService service = new AdminService();
		int result = service.dupCheck(email);
		return "responseBody:" + result;
		
	}

}
