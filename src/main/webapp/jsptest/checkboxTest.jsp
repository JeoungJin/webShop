<%@page import="com.shinhan.model.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
EmpService service = new EmpService();
request.setAttribute("empAll", service.selectAll());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.6.4.min.js" ></script>
<script>
  function call(){
	  var arr=[];
	  $("tbody tr").each(function(index, item){
		  var obj = $(item).find("input");
		  if($(obj).is(':checked')){
			  var row = {};
			  row.first_name = $("td.fname").eq(index).text();
			  row.last_name = $("td.lname").eq(index).text();;
			  arr.push(row);
			  
		  }
		   
	  });
	  console.log(JSON.stringify(arr));
	   
	  $.ajax({
		  url:"young.go",
		  type:"post",
		  data: '[{"name1":"value1", "name2":"value2"}, {"name1":"value3", "name2":"value4"}]',
	      dataType: "json",
	      contentType: 'application/json; charset=utf-8',   
		  success:function(){
			  alert("OK");
			  location.href="${path}/emp/emplist.do";
		  },
		  error:function(){
			  alert("error");
		  }
	  });
  }
</script>
</head>
<body>
    <button onclick="call()">선택완료</button>
	<table>
		<thead>
			<tr>
				<th>순서</th>
				<th></th>
				<th>직원번호</th>
				<th>이름</th>
				<th>성</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empAll}" var="emp" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td><input type="checkbox" name="chk" ></td>
					<td class="fname">${emp.first_name}</td>
					<td class="lname">${emp.last_name}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>