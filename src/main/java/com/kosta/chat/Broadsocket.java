package com.kosta.chat;


import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.kosta.dto.UserVO;

@ServerEndpoint(value="/broadcasting", 
		configurator = GetHttpSessionConfigurator.class)
public class Broadsocket {

	private static Set<Session> clients = Collections
			.synchronizedSet(new HashSet<Session>());
	private Session wsSession;
    private HttpSession httpSession;
    
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		System.out.println(message);
		
		//DB에 저장하기 
		ChatService service = new ChatService();
		UserVO user =  (UserVO)httpSession.getAttribute("user");		
		ChatVO chat = new ChatVO(0, user.getUser_name(), message) ;
		service.insert(chat);
		
		
		synchronized (clients) {
			// Iterate over the connected sessions
			// and broadcast the received message
			for (Session client : clients) {
				if (!client.equals(session)) {
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}

	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		this.wsSession = session;
        this.httpSession = (HttpSession) config.getUserProperties()
                                           .get(HttpSession.class.getName());
		System.out.println(session);
		clients.add(session);
	}

	@OnClose
	public void onClose(Session session) {
		// Remove session from the connected sessions set
		clients.remove(session);
	}
}