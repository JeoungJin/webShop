<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>첫번째 페이지입니다.......</h1>
<%-- <jsp:forward page="b.jsp"></jsp:forward> --%>
<jsp:include page="b.jsp"></jsp:include>
<%-- <%
RequestDispatcher rd = request.getRequestDispatcher("b.jsp");
//rd.forward(request, response);
rd.include(request, response);
%> --%>
</body>
</html>