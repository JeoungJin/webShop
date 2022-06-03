package com.kosta.chat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kosta.util.DBUtil;
import com.kosta.util.LogPreparedStatement;

public class ChatDAO {
	
	static final String SQL_INSERT = "INSERT INTO tbl_chat "+
	   " values( seq_chat.nextval, ?, ? )";
	 
	Connection conn;
	LogPreparedStatement st;
	ResultSet rs;
	int result;
	
	public int insert(ChatVO chat) {
		 
		conn = DBUtil.getConnection();
		try {
			st = new LogPreparedStatement(conn,SQL_INSERT);
            st.setString(1, chat.getUser_name());
            st.setString(2, chat.getContent());
             
			result = st.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}		
		return result;
	}
}
