<%@page import="com.kosta.dto.UserVO"%>
<%@page import="com.kosta.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
UserDAO dao =  new UserDAO();
UserVO user = dao.selectById("zzilre", "1234");

%>
<%=user %>
</body>
</html>