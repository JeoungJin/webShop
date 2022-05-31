<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:setLocale value="en_US"/>
<fmt:bundle basename="resource.member">
  <fmt:message key="mem.name"></fmt:message>
  <fmt:message key="mem.address"></fmt:message>
</fmt:bundle>
</body>
</html>