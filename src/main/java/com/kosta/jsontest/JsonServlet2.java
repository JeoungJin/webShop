package com.kosta.jsontest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class JsonServlet2
 */
@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();

		JSONObject totalObject = new JSONObject();
		//{}
		JSONArray membersArray = new JSONArray();
		//[]
		JSONObject memberInfo = new JSONObject();
		//{name:"박지성","age":25,"gender": "남자","nickname": "날센돌이"}

		memberInfo.put("name", "박지성");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "날센돌이");
        //  배열에 입력
		//[{name:"박지성","age":25,"gender": "남자","nickname": "날센돌이"}]
		membersArray.add(memberInfo);

		//{name:"김연아","age":21,"gender": "여자","nickname": "칼치"}
		memberInfo = new JSONObject();
		memberInfo.put("name", "김연아");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "칼치");
		membersArray.add(memberInfo);
		//[{name:"박지성","age":25,"gender": "남자","nickname": "날센돌이"}
		//,{name:"김연아","age":21,"gender": "여자","nickname": "칼치"}]
		
		totalObject.put("members", membersArray);
		//{"members" : [{name:"박지성","age":25,"gender": "남자","nickname": "날센돌이"}
		//              ,{name:"김연아","age":21,"gender": "여자","nickname": "칼치"}]}
		String jsonInfo = totalObject.toJSONString();//JSON
		System.out.print(jsonInfo);
		writer.print(jsonInfo);
	}

}
