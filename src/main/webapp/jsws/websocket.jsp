<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${path}/js/jquery-3.6.4.min.js"></script>
 
 
 
<style>
.chat_content {color:blue;}
.impress{ color:red;}
.whisper{ color: green;}
</style>
</head>
<body>
    <%@ include file="../common/header.jsp" %> 
	<!-- 로그인한 상태일 경우와 비로그인 상태일 경우의 chat_id설정 -->
	<c:set var="username" value="${loginUser.manager_name}" />
	<c:if test="${(username ne '') and !(empty username)}">
		<input type="hidden" value='${username}' id='chat_id' />
	</c:if>
	<!-- 로그인하지않은경우 -->
	<c:if test="${(username eq '') or (empty username)}">
		<input type="hidden" value="<%=session.getId().substring(0, 6) %>" id='chat_id' />
	</c:if>
	<!-- 채팅창 -->
	<div id="_chatbox" style="display: none">
		<fieldset>
			<div id="messageWindow"></div>
			<br /> <input id="inputMessage" type="text" onkeyup="enterkey()" />
			<input type="submit" value="send" onclick="send()" />
		</fieldset>
	</div>
	<c:set var="chatImage" value="${path}/images/chat.png" />
	<c:set var="chatImage2" value="${path}/images/hide.png" />
	<img class="chat" src="${chatImage}" width="100" height="100"/>
</body>
<!-- 말풍선아이콘 클릭시 채팅창 열고 닫기 -->
<script>
	$(".chat").on({
		"click" : function() {
			if ($(this).attr("src") == "${chatImage}") {
				$(".chat").attr("src", "${chatImage2}");
				$("#_chatbox").css("display", "block");
			} else if ($(this).attr("src") == "${chatImage2}") {
				$(".chat").attr("src", "${chatImage}");
				$("#_chatbox").css("display", "none");
			}
		}
	});
</script>
<script>
	var webSocket = new WebSocket('ws://192.168.0.7:9090/webShop/websocket');
	webSocket.onerror = function(event) {onError(event)};
	webSocket.onopen = function(event) {onOpen(event)};
	webSocket.onmessage = function(event) {onMessage(event)};
	
	function onMessage(event) {
		console.log(event.data);
		var message = event.data.split("|");
		var sender = message[0];
		var content = message[1];
		if (content == "") return; 
		var originalMessage = $("#messageWindow").html();
		
		if (content.match("/")) {
			if (content.match(("/" + $("#chat_id").val()))) {
				 
				var temp = content.replace("/" + $("#chat_id").val(),
						"(귓속말) :").split(":");
				console.log(temp);
				if (temp[1].trim() != "") {
					$("#messageWindow").html(originalMessage
									+ "<p class='whisper'>"
									+ sender
									+ content.replace("/"
											+ $("#chat_id").val(),
											"(귓속말) :") + "</p>");
				}
			} 
		} else {
			if (content.match("!")) {
				$("#messageWindow").html( originalMessage
										+ "<p class='chat_content'><b class='impress'>"
										+ sender + " : " + content
										+ "</b></p>");
			} else {
				$("#messageWindow").html( originalMessage
								+ "<p class='chat_content'>" + sender
								+ " : " + content + "</p>");
			}
		}
		 
	}  
	function onOpen(event) {
		$("#messageWindow").html("<p class='chat_content'>안녕하세요. 채팅에 참여하였습니다.</p>");
	}
	function onError(event) {
		alert(event.data);
	}
	function send() {
		var message = $("#inputMessage").val() ;
		if (message != "") {
			$("#messageWindow").html($("#messageWindow").html() + "<p class='chat_content'>나 : "
							+ message + "</p>");
		}
		
		webSocket.send($("#chat_id").val() + "|" + message);
		$("#inputMessage").val("");
	}
	//     엔터키를 통해 send함
	function enterkey() {
		if (window.event.keyCode == 13) {
			send();
		}
	}
	//     채팅이 많아져 스크롤바가 넘어가더라도 자동적으로 스크롤바가 내려가게함
	window.setInterval(function() {
		var elem = $('#messageWindow');
		elem.scrollTop = elem.scrollHeight;
	}, 0);
</script>

</body>
</html>