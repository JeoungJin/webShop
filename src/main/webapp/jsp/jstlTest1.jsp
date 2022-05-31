<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL 연습</h1>
<pre>
1. set (setAttribute) :
    <c:set var="myName"  value="jin" scope="page" />
    <c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>

    <%-- pageCotext.setAttrubute("myName", "jin") --%>
2.get (getAttrubute) : ${myName}
   컨텍스트패스 : ${path }
   
3.반복문
   <c:forEach begin="1" end="5" step="1" var="num">
      ${num}  
   </c:forEach>
   <%
   String[] arr = {"월","화","수","목","금","토","일" };
   request.setAttribute("week", arr);
   %>
   <c:forEach  items="${week}" var="day" varStatus="status">
      ${status.index}/${status.count}/${status.first}/${status.last} 
         <c:if test="${status.first}">
              <span style="color:red">${day}</span> 
         </c:if>
         <c:if test="${status.last}">
              <span style="color:blue">${day}</span> 
         </c:if> 
         <c:if test="${status.first==false && status.last!=true}">
              <span>${day}</span> 
         </c:if>
   </c:forEach>
 4. token
  <c:set var="subject" value="자바,SQL,JSP/Servlet,Spring" />
  <c:forTokens items="${subject}" delims="," var="ss">
     ${ss }
  </c:forTokens>
  
</pre>
</body>
</html>





