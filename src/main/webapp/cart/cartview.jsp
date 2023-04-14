<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인한 사용자 : ${loginUser.manager_name }</h2>
 <%
	Object obj = session.getAttribute("cart");
	if(obj!=null) {
		HashMap<String, Integer> cart = (HashMap<String, Integer>)obj;
		for(String key  : cart.keySet()) {
			out.println("<h1>" + key + "===>" + cart.get(key) + "</h1>");
		}
	}
 %>
 <a href="addCart.do">계속쇼핑</a>
</body>
</html>



