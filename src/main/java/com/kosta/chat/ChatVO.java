package com.kosta.chat;

public class ChatVO {
	private int chat_no ; 
	private String user_name; 
	private String content ;
	public ChatVO() {}
	public ChatVO(int chat_no, String user_name, String content) {
		super();
		this.chat_no = chat_no;
		this.user_name = user_name;
		this.content = content;
	}
	public int getChat_no() {
		return chat_no;
	}
	public void setChat_no(int chat_no) {
		this.chat_no = chat_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatVO [chat_no=").append(chat_no).append(", user_name=").append(user_name).append(", content=")
				.append(content).append("]");
		return builder.toString();
	}
	
	
}
