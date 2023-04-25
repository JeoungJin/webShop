 
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.shinhan.util.MySQLUtil"%>
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
Connection conn = MySQLUtil.getConnection();
out.println(conn + "<br>");

/* String sql = "select count(*) from employees";
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery(sql);
while (rs.next()) {
	out.print(rs.getInt(1));
} */
%>
</body>
</html>