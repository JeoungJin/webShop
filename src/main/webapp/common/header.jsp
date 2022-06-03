<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
 
<div> 
      <c:set var="path" value="${pageContext.request.contextPath }"/>
	 
	  <c:if test="${user != null }">
	       
	      <span class="text-white">${user.user_name}님 환영</span>
	      <a href="javascript:f_logOut();">로그아웃</a>
	      
	  </c:if>
	  <c:if test="${user == null }">
	      <span class="text-white">Guest님 환영</span> 
	      <a href="javascript:f_logIn();">로그인</a>
	  </c:if>   	
	  
</div>
 
