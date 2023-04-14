<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! %>
<% %>
<%=1+2 %>
<%-- --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JavaBean이용하기</h1>
<%
/* String a = request.getParameter("email");
String b = request.getParameter("manager_name");
String c = request.getParameter("pass"); 
AdminVO vo = new AdminVO();
vo.setEmail(a);
vo.setManager_name(b);
vo.setPass(c); */
%>
<!-- useBean : 객체생성
     setProperty : setter수행 , "set" + "Email"=>setEmail()
     setProperty : setter수행 , "set" + "email"=>setemail()
 -->
<jsp:useBean id="vo" class="com.shinhan.vo.AdminVO"></jsp:useBean>
<jsp:setProperty property="email" name="vo" param="email"  />
<jsp:setProperty property="manager_name" name="vo"  />
<jsp:setProperty property="pass" name="vo"  />

<jsp:useBean id="vo2" class="com.shinhan.vo.AdminVO"></jsp:useBean>
<jsp:setProperty property="*" name="vo2"/>
vo2: <%=vo2 %>
<hr> 

email: <jsp:getProperty property="email" name="vo"/> <br>
name : <jsp:getProperty property="manager_name" name="vo"/> <br>
pass: <jsp:getProperty property="pass" name="vo"/> <br>

</body>
</html>