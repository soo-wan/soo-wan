package com.himedia.test1.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Db {

	public static Connection getConnection() {
		Connection con=null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds =(DataSource)envContext.lookup("jdbc/MysqlDB");
			con = ds.getConnection();
		}catch (NamingException e) { e.printStackTrace();
		}catch (SQLException e ) { e.printStackTrace();
		}
		return con;
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(con != null) con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		}catch (SQLException e ) { e.printStackTrace();
		}
	}

}
