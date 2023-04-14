package com.shinhan.frontcontrollerpattern;

import java.util.Map;

public class LayoutTestController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		String page = "layoutTest.jsp";
		return page;
	}

}
