<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Testing websockets</title>
  </head>
<body>
    <div class="form-group">
        <textarea class="form-control" id="messageWindow" rows="10" cols="50" readonly="readonly"></textarea>
        <br/>
        <input class="form-control" id="inputMessage" type="text"/>
        <input type="submit"  class="btn btn-primary" value="send" onclick="send()" />
    </div>
</body>
    <script type="text/javascript">
        var textarea = document.getElementById("messageWindow");
        var webSocket = new WebSocket('ws://localhost:9090/webShop/broadcasting');
        var inputMessage = document.getElementById('inputMessage');
    webSocket.onerror = function(event) {
      onError(event)
    };

    webSocket.onopen = function(event) {
      onOpen(event)
    };

    webSocket.onmessage = function(event) {
      onMessage(event)
    };

    function onMessage(event) {
        textarea.value += "상대 : " + event.data + "\n";
    }

    function onOpen(event) {
        textarea.value += "채팅서버 연결 성공\n";
    }

    function onError(event) {
      alert(event.data);
    }

    function send() {
        textarea.value += "${user.user_name} : " + inputMessage.value + "\n";
        webSocket.send(inputMessage.value);
        inputMessage.value = "";
    }
  </script>
</html>