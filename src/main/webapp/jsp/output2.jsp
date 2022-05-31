<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kosta.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
//error연습을 위해 추가함
 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>~~~~장바구니 현황(Map이용)~~~~</h1>
<%
request.setCharacterEncoding("utf-8");
String prodName = request.getParameter("prod");

String s_count =  request.getParameter("count");
int i_count = 0;
if(s_count !=null){
	i_count = Integer.parseInt(s_count);
}
Product pro = new Product(prodName, i_count);
//장바구니가 session에 있으면 얻기, 없으면 만든다.
Map<String, Product> plist = (HashMap)session.getAttribute("cart");
if(plist == null) plist = new HashMap<>(); //장바구니 
///같은 상품이 있으면 갯수를 수정한다. 



if(plist.containsKey(prodName)){
	Product p2 = plist.get(prodName);
	p2.setCount(p2.getCount() + i_count);//수정 
}else{
	if(prodName != null)  plist.put(prodName, pro);
}
 
session.setAttribute("cart", plist);

//출력
for(String key:plist.keySet()){
	Product p = plist.get(key);  
	out.write("<p>" + p.getName() + ":" + p.getCount() + "</p>");
 }
//JSP내장객체 : application, session, request, pageContext
//            out
%>


<a href="input.jsp">계속구매하기</a>
<button id="btnClear" onclick="location.href='cartRemove'" >장바구니비우기</button>
</body>
</html>



