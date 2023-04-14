package com.shinhan.frontcontrollerpattern;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.shinhan.model.EmpService;
import com.shinhan.vo.EmpVO;

public class EmpListController implements CommonControllerInterface{

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		EmpService service = new EmpService();
		List<EmpVO> emplist = service.selectAll();
		//request가 유지되는 동안 저장한다. 
		HttpServletRequest request = (HttpServletRequest)data.get("request");
		request.setAttribute("empAll", emplist);
		
		//위임(내가 요청을 받고 응답은 다른 페이지가 한다.)
		return "empSelect.jsp";
		
	}

}
