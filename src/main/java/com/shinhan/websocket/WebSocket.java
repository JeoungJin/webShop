package com.shinhan.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.shinhan.vo.AdminVO;

/*@ServerEndpoint는 클라이언트에서 서버로 접속 할 주소로 지정.
@OnMessage에서는 클라이언트로 부터 메시지가 도착했을때 처리.
@OnOpen은 클라이언트에서 서버로 접속할 때의 처리.
@OnClose는 접속이 끊겼을때 처리*/

@ServerEndpoint(value = "/websocket"  )
public class WebSocket {
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	//private static final Map<Session, HttpSession> sessionMap = new HashMap<>(); 
	
	 

	// 웹 소켓 연결시 호출
	@OnOpen
	public void onOpen(Session session ) {
		//HttpSession httpSession = (HttpSession)config.getUserProperties().get("PRIVATE_HTTP_SESSION");
		
		 
		
		//System.out.println("session id"+session.getId());
		//System.out.println("httpSession id:" + httpSession.getId());
		//sessionMap.put(session, httpSession);
		clients.add(session);
	}

	// 웹소켓 메시지 수신시 호출
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		System.out.println("~" + message);
		//HttpSession httpSession = sessionMap.get(session);
		//System.out.println("onMessage httpSession:" +httpSession.getId());
		synchronized (clients) {
			for (Session client : clients) {
				if (!client.equals(session)) {
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}

	// 웹 소켓이 닫힐 때 세션 제거
	@OnClose
	public void onClose(Session session) {
        
		/*
		 * HttpSession httpSession = sessionMap.get(session); ServletContext app =
		 * httpSession.getServletContext(); Object obj = app.getAttribute("userList");
		 * AdminVO admin; admin = (AdminVO)httpSession.getAttribute("loginUser");
		 * System.out.println("onClose AdminVO:" + admin);
		 * 
		 * List<AdminVO> userList = null; if(obj !=null) { userList =
		 * (List<AdminVO>)obj; userList.remove(admin); app.setAttribute("userList",
		 * userList); System.out.println("onClose:" + userList); }
		 * httpSession.invalidate();
		 * 
		 * sessionMap.remove(session);
		 */
		clients.remove(session);
	}

	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}
}