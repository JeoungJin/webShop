<%@page import="java.io.File"%>
<%@page import="com.shinhan.qr.QRUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QR생성</title>
</head>
<body>
<%
String url = "http://192.168.0.7:9090/webShop/auth/loginCheck.do";
int width = 150;
int height = 150;

String file_path = "c:"+File.separator+"qr"+File.separator;
String file_name = "mysite.png";
QRUtil.makeQR(url , width , height , file_path , file_name);
%>
</body>
</html>