<%@page import="com.shinhan.excel.ExcelUploadTest"%>
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
ExcelUploadTest.excelFileRead(request);
%>
</body>
</html>