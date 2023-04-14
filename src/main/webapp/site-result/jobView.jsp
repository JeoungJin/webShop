<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<ul>
  <!-- 5건의 데이터만 출력하기 --> 
  <c:forEach begin="1" end="5" var="index">
    <li>${jobList[index].job_id}--------${jobList[index].job_title } </li>
  </c:forEach>
</ul>