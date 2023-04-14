<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<c:set var="path" value="${pageContext.request.contextPath}" 
            scope="application"></c:set>
<%
String company = "신한금융소프트아카데미";
%>
<div style="border:5px dotted green;"> 
	
	<%-- <div>세션에서 로그인사용자읽기(EL): ${sessionScope.loginUser}</div> --%>
	<%-- <div>
		세션에서 로그인사용자읽기(ScriptLet):
		<%=session.getAttribute("loginUser")%>
	</div> --%>
	
	<c:if test="${loginUser!=null }">
	    <div>로그인한 사용자: ${loginUser==null?"guest":loginUser.manager_name}</div>
	    <button id="btnLogout"> 로그아웃</button>
	    <img src="${path}/uploads/${loginUser.pic}"/>
	</c:if>
	<c:if test="${loginUser==null }">
	    <button onclick="location.href='${path}/auth/loginCheck.do'">로그인</button>
	</c:if>
</div>

<script>
    $(function(){
    	$("#btnLogout").on("click", function(){
    		 
    		$.ajax({
    			url:"${path}/auth/logout.do",
    			success:function(responseData){
    				alert(responseData + "로그아웃되었습니다.");
    				location.href="${path}/auth/loginCheck.do";
    			},
    			error:function(message){
    				alert(message);
    				console.log(message);
    			}
    			
    		});
    	});
    });
  </script>