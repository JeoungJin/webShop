package com.kosta.jinTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleClodeTest {

 
	//String DB_URL="jdbc:oracle:thin:@kosta226_medium?TNS_ADMIN=C:/0.kosta226/Wallet_kosta226/";
	String DB_URL="jdbc:oracle:thin:@jeonghyeon_medium?TNS_ADMIN=C:/0.kosta226/Wallet_jeonghyeon/";
	String DB_USER = "admin";
	//String DB_PASSWORD = "Kosta226good";
	String DB_PASSWORD = "jeonghyeonKosta1";
	public void dbConnect2() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		System.out.println(conn);
		String sql = "select * from jeonghyeon";
		Statement st = null;
		ResultSet rs = null;
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getInt(1));
		}
		rs.close();
		st.close();
		conn.close();
	}

}
