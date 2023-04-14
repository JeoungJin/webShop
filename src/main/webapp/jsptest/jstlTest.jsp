<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/commonfiles.jsp" %>
</head>
<body>
<h1>JSTL연습</h1>
<%@ include file="../common/header.jsp" %>
<jsp:include page="../common/header.jsp" ></jsp:include>
<button onclick='location.href="${path}/aa/bb}"'></button>
!!!!!!!!!${happy1 }
<h2>contextPath(appliation에 저장되어있음--header에서함) :   ${path }</h2>
<c:set var="happy" value="${param.jumsu}"></c:set>

<c:set var="happy1" value="1" scope="page"/>
<c:set var="happy2" value="2" scope="request"/>
<c:set var="happy3" value="3" scope="session"/>
<c:set var="happy4" value="4" scope="application"/>
!!!!!!!!!${happy1 }
<h1>점수는 ${happy }</h1>
<p>page : ${happy1}</p>
<p>request : ${happy2}</p>
<p>session : ${happy3}</p>
<p>application : ${happy4}</p>






<c:forEach begin="1" end="10" step="1" var="su">
  <p>${su }</p>
</c:forEach>
</body>
</html>