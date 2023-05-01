package com.shinhan.websocket;

import java.text.MessageFormat;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class HttpSessionConfigurator extends Configurator {
	private HttpSession httpSession;

	// modifyHandshake() is called before getEndpointInstance()!
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, 
    		   HandshakeResponse response) {
        HttpSession session= (HttpSession) request.getHttpSession();
        if(session!=null) {
        	System.out.println("modifyHandshake:"+session.getAttribute("loginUser"));
        	sec.getUserProperties().put("PRIVATE_HTTP_SESSION", session);
        }
         
    }

     
}