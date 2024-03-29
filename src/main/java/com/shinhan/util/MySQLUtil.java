package com.shinhan.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MySQLUtil {
/*
 *  mysql> create user itemfarm@'%' identified by '1234';
			Query OK, 0 rows affected (0.01 sec)

	mysql> grant all privileges on itemfarm.* to itemfarm@'%';
			Query OK, 0 rows affected (0.00 sec)	
 */
	 
	//1.DB연결
		public static Connection getConnection() {
			Connection conn = null;
			Context initContext;
			try {
				initContext = new InitialContext();
				Context envContext  = (Context)initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB2");
				conn = ds.getConnection();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return conn;
		}
		/*
		public static Connection getConnection() {
			Connection conn = null;
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String userid="hr", password="hr";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, userid, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}*/
		 //2.자원반납
		public static void dbDisconnect(ResultSet rs, Statement st, Connection conn) {
			try {
				if(rs!=null)  rs.close();
				if(st!=null) st.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
