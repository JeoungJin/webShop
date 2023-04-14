package com.shinhan.frontcontrollerpattern;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.shinhan.model.AdminService;
import com.shinhan.vo.AdminVO;
import com.shinhan.vo.JobVO;

public class AdminPicAjaxController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		AdminService service = new AdminService();
		HttpServletRequest request = (HttpServletRequest)data.get("request");
		HttpServletResponse response = (HttpServletResponse)data.get("response");
		List<AdminVO> adminList = service.adminList();
		
		//2)방법2
		JSONArray arr = new JSONArray();
		for(AdminVO vo:adminList) {
			JSONObject obj = new JSONObject();
			obj.put("mname", vo.getManager_name());
			obj.put("pic", vo.getPic());
			arr.add(obj); 
		}
		 
		JSONObject jobsObj = new JSONObject();
		jobsObj.put("picList", arr);
		
		return "responseBody:" + jobsObj.toJSONString();
		 
		//1)방법1
		//request.setAttribute("adminList", adminList);
		//return "adminView.jsp";
	}

}




