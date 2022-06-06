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

<h1>게시판 목록</h1>
 
<h3>
  application정보얻기 : ${myname }
  
</h3>

<c:set var="path" value="${pageContext.request.contextPath }"/>

<a href="${path}/board/boardInsert.do">게시글 작성하기</a>
<br><br>
<table>
 <tr>
   <td>순서</td>
   <td>번호</td>
   <td>제목</td>
   <td>내용</td>
   <td>작성자</td>
   <td>작성일</td>
   <td>수정일</td>
   <td></td>
 </tr>
 <%-- jsp주석이다 --%>
 <!-- HTML주석이다. -->
 전체건수: ${boardSize} <br>
 <c:set var="listSize" value="${boardDatas.size()}" ></c:set>
    
 <c:forEach items="${boardDatas}" var="board" varStatus="rowStatus">
  <tr class="${rowStatus.count%2==0?'color1':'color2'}">
   <td>${rowStatus.count}....${listSize-rowStatus.index} </td>
   <td><a href="${path}/board/boardDetail.do?boardid=${board.bno}">${board.bno}</a></td>
   <td>${board.title }</td>
   <td>${board.content }</td>
   <td>${board.writer }</td>
   <td>${board.regdate }</td>
   <td>${board.updatedate }</td>
   <td><button class="btnDel btn-primary" data-bno="${board.bno}" >삭제하기</button></td>
 </tr>
 </c:forEach>
</table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(function(){
	//# : 아이디를 의미, 아이디는 문서내에서 융ㄹ하다. 
	//.:class를 의미

	$(".btnDel").click(function(){ 
		var bno = $(this).attr("data-bno");
		if(confirm(bno + "삭제?")){
			location.href = "${path}/board/boardDelete.do?bno=" + bno;
		}
	});
});
</script>
</body>
</html>




