<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
 <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>
 table, td { border:1px solid black; padding: 10px; border-collapse: collapse;}
 tr:first-child { background-color: lightgreen;}
 
.color1 { background-color: pink;}
.color2 { background-color: beige;}
tr:nth-child(odd) {
     background-color: lightgray;
 }
 tr:nth-child(even) {
     background-color: white;
 }
  tr:first-child {
     background-color: orange;
 }
</style>

</head>
<body>
 	 
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="javascript:call1();">직원정보</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="javascript:call2();">부서정보</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="javascript:call3();">게시판정보</a>
      </li>       
      <li class="nav-item">
        <a class="nav-link" href="javascript:call4();">채팅</a>
      </li> 
    </ul>
    <!-- <form class="form-inline" action="">
    	<input class="form-control mr-sm-2" type="text" placeholder="Search">
    	<button class="btn btn-success" type="submit">Search</button>
    </form> -->
  </div>  
  
   <div>
        <jsp:include page="common/header.jsp"/>
     
   </div>
   
</nav>
<br>

<div class="container">
  <h1>jsp, servlet 학습하기</h1>
   
</div>
	

 
	<script>
		 
		
		function call1(){
			$.ajax({
				url:"emp/emplist.do",
				type:"get",
				success : function(responseData){
					$(".container").html(responseData);
				}
			});
		} 
		function call2(){
			$.ajax({
				url:"dept/deptlist.do",
				type:"get",
				success : function(responseData){
					$(".container").html(responseData);
				}
			});
		}
		function call3(){
			$.ajax({
				url:"board/boardlist.do",
				type:"get",
				success : function(responseData){
					$(".container").html(responseData);
				}
			});
		}
		function call4(){
			$.ajax({
				url:"chat/broadcast.jsp",
				type:"get",
				success : function(responseData){
					$(".container").html(responseData);
				}
			});
		}
		function f_logOut(){
			$.ajax({
				url:"logOut" ,
				type:"get",
				success : function(responseData){
					alert(responseData);
					$(".container").html(responseData);
					
				}
			});
		} 
		function f_logIn(){
			alert("2");
			$.ajax({
				url:"html/login.do" ,
				type:"get",
				success : function(responseData){
					alert(responseData);
					$(".container").html(responseData);
				}
			});
		} 
	</script>
</body>
</html>



