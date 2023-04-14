package com.shinhan.frontcontrollerpattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shinhan.vo.AdminVO;

public class JSTLController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		//  /로 시작하면 절대 /가 없으면 상대경로이다.
		// /webShop생략되어있으므로 현재는 모두가능하다. 
		HttpServletRequest request = (HttpServletRequest)data.get("request");
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		application.setAttribute("myName", "김길동application");
		session.setAttribute("myName", "박길동session");
		request.setAttribute("myName", "홍길동request");
		
		List<AdminVO> adminList = new ArrayList<>();
		adminList.add(new AdminVO("abc1@daum.net", "김1", "1234"));
		adminList.add(new AdminVO("abc2@daum.net", "김2", "1234"));
		adminList.add(new AdminVO("abc3@daum.net", "김3", "1234"));
		request.setAttribute("admins", adminList);

		request.setAttribute("score", 99);
		request.setAttribute("today", new Date());
		 
		//int count=0
		//request.setAttribute("count",0);
		//for(AdminVO admin:adminList) {			
		//}
		 
		return "/jsptest/jstlTest3.jsp";
	}

}
