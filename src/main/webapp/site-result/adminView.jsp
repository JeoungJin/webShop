<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>갤러리 내용입니다.</h2>
<ul>
  <c:forEach items="${adminList}" var="admin">
     <li><img src="${path}/uploads/${admin.pic}" width="100" height="100"></li>
  </c:forEach>
                          
</ul>
          