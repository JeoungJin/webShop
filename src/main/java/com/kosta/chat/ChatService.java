package com.kosta.chat;

public class ChatService {

	ChatDAO dao = new ChatDAO();
	
	public int insert(ChatVO chat) {
		return dao.insert(chat);
	}
}
