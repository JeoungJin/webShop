<%@page import="com.shinhan.vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 
<%-- <jsp:include   page="../common/commonfiles.jsp"></jsp:include>  --%>
 
<%@ include file="../common/commonfiles.jsp" %>

<style>
  /* #container{
       
      width: 80%;
      margin: 0 auto;
  }
  h1{
    border : 1px solid gray;
    text-align: center;
    width:100%;
    
  }
  thead tr, thead td{
	 background-color: lightblue;
	 padding: 10px;
  }
  table, tr, td{
     border: 1px solid gray;
     border-collapse: collapse;
     padding: 0.5em;
  }
  .aa:hover, 	::selection {
    background-color: orange;
  } */
  .orange{
    background-color: orange;
  }
  .white{
    background-color: white;
  }
  table tbody tr:hover{ background-color: orange;}
  
  
</style>

  <script>
   
   $(function(){
	   //document.querySelectorAll(".btnDel")
	   //document.getElementsByClassName("btnDel")
	   
	   //---입력성공후 메시지보여주기 추가함
	   var message = "${message}";
	   if(message){
		   alert(message);
		   message = null;
	   }
	   //---입력성공후 메시지보여주기 추가함
	   
	   
	   $(".btnDel").on("click", f);
   });
   var f = function(){		   
	   location.href="${path}/emp/empDelete.do?empid=" + $(this).attr("data-del");
   }
  
    
  
   $(function(){
	   $("thead tr th").click(function(e){
		   //내가 클릭한 th가 몇번째인가?
		   var trNum = $(this).closest("th").prevAll().length;
		   		    
		   
		   
		   sortTable(trNum);
		   var a = $("tbody tr").each(function(index, item){
			   var col = $(item).find("td:nth-child(" + (trNum+1) + ")");
			   console.dir(col);
			   //되돌리기(기존선택을 clear)
			   $(item).find("td").css("background-color", "white");
			   //신규선택의 색깔 바꾸기
			   $(col).css("background-color", "orange");
			   //$(item).find("td").removeClass("white");
			   //$(col).addClass("orange")
		   });  
		   
	   });
   });
  </script>
  <script>
    function init(){
    	$("tr").css("background-color", "white")
    	$("tr").css("color", "black");
    }
    $(function(){
    	
    	$("#btn1").click(function(){
    		$("tr:nth-child(2n)").css("background-color", "lightgray");
        	$("tr:nth-child(2n+1)").css("background-color", "white");
    	});
    	//body > div > table > tbody > tr:nth-child(1) > td:nth-child(2)
    	$("#btn2").click(function(){
    		init();
    		$("tr > td:nth-child(2):contains('S')").css("color", "red");
    	});
    	$("#btn3").click(function(){
    		init();
    		$("tr td:contains('S')").css("color", "red");
        	
    	});
    	$("#btn4").on("click", function(){
    		init();
    		var selector = "tr > td:nth-child(5)";
    		
    		$(selector).each(function(index, item){
    			var sal = parseInt($(item).html()) ;
    			if(sal >= 5000) {
    				$(item).css("background-color", "lightgreen")
    			}
    		});
    	});
    	
    	$("#btn5").click(function(){
    		var arr = $("tr>td:nth-child(1)");
    		$.each(arr, function(index, item){
    			if(parseInt($(item).text())%2==1){
    				console.log($(item).text());
    				$(item).parent().css("background-color", "green");
    			}
    		});
    	});
    	
    	
    	var str="";
    	var arr = ["IT_PROG", "AD_VP","AD_PRES","ST_MAN","ST_CLERK"];
    	$.each(arr, function(index, item){
    		console.log(item);
    		//str += `<option>${item}</option>`;
    		str += "<option>" + item + "</option>";
    	});
    	
    	$("#jobs").html(str);  //html() : jQuery함수 , innerHTML는 자바스크립트 속성 
    	console.log(str);
    	
    	$("select").change(function(){
    		var jobid = $(this).val();
    		//init();
    		$("tr td").css("color","black");
    		$("tr td:contains('" + jobid + "')").css("color", "red");
    	});

    });
  </script>
  <script>
  let a = ["바나나", "사과", "오렌지"];
  let b = ["1", "2", "3"];
  let zip = a.map(function (item, index) {
    return [item, b[index]];
  });
  console.log(zip);
  
  </script>
</head>
<body>

<c:set var="message" value="" scope="session"/>
<div class="container mt-3">
	<h1>직원목록</h1>
	<script>
	 console.log(location.href);
	</script>
    
 
   
	<!-- include 디렉티브는 소스를 합쳐서 컴파일한다.  -->
    <%-- include지시자 : 합쳐서 컴파일  --%>
    <%@ include file="../common/header.jsp" %>
    <!-- include action tag이용: 컴파일하고 합침 -->
    <%-- <jsp:include page="../common/header.jsp"></jsp:include> --%>
    <h2><%=company %></h2>
   	<button 
	onclick="location.href='${path}/emp/empinsert.do'"
	type="button" class="btn btn-success">직원등록</button>
 	<a type="button" class="btn btn-success" href="${path}/emp/empinsert.do">직원등록</a>
 	
 	
 	<button type="button" class="btn btn-primary" 
 	           data-myname="정진"
 	           data-emp1="${empAll[0]}"
 	           data-bs-toggle="modal" 
 	           data-bs-target="#exampleModal" 
 	           data-bs-whatever="@mdo"
 	           >Modal이용 직원등록</button>
 	<button id="btnModalShow" onclick="call3()" class="btn btn-primary" >Modal보이기</button>
 	<button style="cursor:not-allowed" disabled>not-allowed(아이콘test)</button>	
 	<form method="post"  action="${path}/downloadTest/result.jsp" >
	 <input type=hidden  name="param1" value="watch.jpg" />  
	 <input type=hidden  name="param2" value="umbrella.jpg" />  
     <input type ="submit" value="이미지 다운로드" class="btn btn-primary" >	 
    </form>
 	<%@ include file="empInsertModal2.jsp" %>
 	<script>
 	   $(function(){
 			$('#exampleModal').on('show.bs.modal', function(event) {  
 		 		var myname = $(event.relatedTarget).data('myname');
 		 		var emp1 = $(event.relatedTarget).data('emp1');
 		 		emp1 = emp1.replace(/\'/gi, '"');
 		 		console.log(emp1)
 		 		var obj = JSON.parse("{" + emp1 + "}");
 		        $("#my").val(obj["first_name"]);
 		        console.log(obj["last_name"])
 		    });
 	   });
	 	
	</script>
	
 	
	<hr>
	<fieldset>
	    <legend>조건data찾기(selector)</legend> 
		<button id="btn1">짝수row선택</button>
		<button id="btn2">이름 S로 시작하는 직원</button>
		<button id="btn3">S문자가 포함</button>
		<button id="btn4">급여5000이상</button>
		<button id="btn5">직원 번호가 홀수인 사람 선택</button>
		<select id="jobs"></select>
	</fieldset>
	<hr>
	
	<table class="table table-hover" id="myTable">
	  <thead>
	   <tr>
	     <th></th>
	     <th>seq</th>	     <th>empid</th>
	     <th>이름</th>	     <th>성</th>
	     <th>이메일</th>	     <th>급여</th>
	     <th>누적급여</th>	     <th>입사일</th>
	     <th>전화번호</th>	     <th>직책</th>
	     <th>manager</th>	 <th>comm</th>
	     <th>부서</th>	     <th>delete</th>
	   </tr>
	 </thead>
	 <tbody> 
	   <c:set var="totalSalary" value="0" />
	   <c:forEach items="${empAll}" var="emp" varStatus="status">
	   <c:set var="totalSalary" value="${totalSalary+emp.salary}"/>
	   
	   <tr>
	     <td>
	     <button type="button" class="btn btn-success" 
 	           data-emp1="${empAll[status.index]}"
 	           data-bs-toggle="modal" 
 	           data-bs-target="#exampleModal" 
 	           >modal(param)</button>
	     </td>
	     <td style="background-color:${status.first||status.last?'orange':'white'};">${status.count }</td>
	     <td><a href="${path}/emp/empDetail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td>
	     <td ><a  style="color:${fn:length(emp.first_name)>3?'red':'blue'};" href="${path}/emp/empDetail.do?empid=${emp.employee_id}">
	           ${emp.first_name}
	     </a>
	     </td>
	     <td>${emp.last_name}</td>
	     <td>${emp.email}**
	         <%-- ${fn:substring(emp.email,0,3)}**
	         ${fn:indexOf(emp.email,"@") }**
	         ${fn:indexOf(emp.email,"@")>=0?fn:substring(emp.email,0,1):emp.email } --%>
	     </td>
	     <td>   
	        <format:formatNumber value="${emp.salary}" groupingUsed="true" />
	     </td>
	     <td>${totalSalary}</td>
	     <td>
	        <format:formatDate pattern="yyyy/MM/dd"   value="${emp.hire_date}"/>
	     </td>
	     <td>${emp.phone_number}</td>
	     <td>${emp.job_id}</td>
	     <td>${emp.manager_id}</td>
	     <td>
	        <format:formatNumber  type="percent" value="${emp.commission_pct}" />
	     </td>
	     <td>        
	       <select style="appearance:none" disabled="disabled">
	         <c:forEach items="${deptList}" var="dept">
	           <option value="${dept.department_id}" ${emp.department_id==dept.department_id?"selected":""}>${dept.department_name}</option> 	         
	         </c:forEach>
	         
	       </select>
	     </td>
	     <td><img src="${path}/images/delete.png" width="20" height="20" class="btnDel" data-del="${emp.employee_id}"></td>
	   </tr>
	  </c:forEach> 
	</tbody> 
	 
	</table>
</div>	
 <script>
 function sortTable(seq) {
	  var table, rows, switching, i, x, y, shouldSwitch;
	  table = document.getElementById("myTable");
	  switching = true;
	  /*Make a loop that will continue until
	  no switching has been done:*/
	  while (switching) {
	    //start by saying: no switching is done:
	    switching = false;
	    rows = table.rows;
	    console.log(rows);
	    /*Loop through all table rows (except the
	    first, which contains table headers):*/
	    for (i = 1; i < (rows.length - 1); i++) {
	      //start by saying there should be no switching:
	      shouldSwitch = false;
	      /*Get the two elements you want to compare,
	      one from current row and one from the next:*/
	      x = rows[i].getElementsByTagName("td")[seq];
	      y = rows[i + 1].getElementsByTagName("td")[seq];
	      //check if the two rows should switch place:
	      if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
	        //if so, mark as a switch and break the loop:
	        shouldSwitch = true;
	        break;
	      }
	    }
	    if (shouldSwitch) {
	      /*If a switch has been marked, make the switch
	      and mark that a switch has been done:*/
	      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
	      switching = true;
	    }
	  }
	}
 </script>
</body>
</html>