<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404오류</title>
<style>
 div{
  font-family: arial;
  font-size: 15px;
  margin: 0 auto;
  width: 70%;
  position: relative;
  
 }
 img {   
   position: relative;
   left: 30%; 
   width:400px;height: 400px;
   margin: 0 auto;
   }
  h1,h2{text-align: center;} 
</style>
</head>
<body>
<div  >
	<img src="${pageContext.request.contextPath}/images/404-error-3060993_640.png"/>
	<h1>★★★서버에서 보낸메시지★★★</h1>
	<h2>${errorMessage}!!</h2>
	<h2 id="here"></h2>
</div>
<script>
  here.innerHTML = "입력주소 확인:" + location.href;
</script>
</body>
</html>







