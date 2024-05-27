package com.himedia.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbm {
	
	static String driver ="com.mysql.cj.jdbc.Driver";
	static String url ="jdbc:mysql://localhost:3306/board";
	static String id ="root";
	static String pw ="adminuser";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return con; //연결 객체 리턴
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try{
			if(con!=null) con.close();
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		}catch(Exception e){
			e.printStackTrace();
			//전달 받은 객체 close
		}
	}
}
