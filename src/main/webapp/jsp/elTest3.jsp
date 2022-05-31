<%@page import="com.kosta.dto.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kosta.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
BoardDTO board = new BoardDTO("월요일","EL연습....", 100);
application.setAttribute("boardVO", board);
session.setAttribute("boardVO", new BoardDTO("화요일","EL연습....", 100));
request.setAttribute("boardVO", new BoardDTO("수요일","EL연습....", 100));
pageContext.setAttribute("boardVO", new BoardDTO("목요일","EL연습....", 100));

List<BoardDTO> blist = new ArrayList<>();
blist.add(new BoardDTO("A","EL연습....", 100, new EmpVO(100,"홍1","길동")));
blist.add(new BoardDTO("B","EL연습....", 100, new EmpVO(200,"홍2","길동")));
blist.add(new BoardDTO("C","EL연습....", 100, new EmpVO(300,"홍3","길동")));
blist.add(new BoardDTO("D","EL연습....", 100, new EmpVO(400,"홍4","길동")));
blist.add(new BoardDTO("E","EL연습....", 100, new EmpVO(500,"홍5","길동")));
request.setAttribute("boardList", blist);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL연습</title>
</head>
<body>
<h1>EL연습</h1>
<pre>
1.EL이용읽기 : ${boardVO}
1.EL이용읽기 : ${applicationScope.boardVO}
1.EL이용읽기 : ${sessionScope.boardVO}
1.EL이용읽기 : ${requestScope.boardVO}
1.EL이용읽기 : ${pageScope.boardVO}
<hr>
2.ScriptLet의 Expression : <%=board %>
2.ScriptLet의 Expression : <%=application.getAttribute("boardVO") %>
<hr>
3.List읽기 : ${boardList }
<ul>
  <c:forEach items="${boardList }" var="b">
      <li>${b.title}.......${b.content }....${b.emp.employee_id}...${b.emp.first_name}...${b.emp.last_name}...</li>   <%--b.getTitle(), b.getContent() 호출된다. --%>
  </c:forEach>
</ul>
<%-- jsp:forward는 표준액션이다. 
forward는 요청과 응답을 다른페이지로 넘긴다. 
include는 요청과 응답을 다른페이지로 넘기고 그 페이지가 이 페이지로 포함된다. 
--%>
<jsp:include page="elTest4.jsp"></jsp:include>


</pre>
</body>
</html>


