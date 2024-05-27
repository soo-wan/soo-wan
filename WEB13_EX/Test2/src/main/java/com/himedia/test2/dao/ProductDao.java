package com.himedia.test2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.himedia.test2.util.Db;
import com.himedia.test2.vo.ProductVO;

public class ProductDao {
		private ProductDao() {}
		private static ProductDao itc = new ProductDao();
		public static ProductDao getInstance() {return itc;}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		public void insertProduct(ProductVO pvo) {
			con = Db.getConnection();
			String sql = "insert into product(kind, name, price1, price2, price3, content, "
					+ " image, savefilename) values(?, ?, ?, ?, ?, ?, ?, ?)"; 
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, pvo.getKind());
				pstmt.setString(2, pvo.getName());
				pstmt.setInt(3, pvo.getPrice1());
				pstmt.setInt(4, pvo.getPrice2());
				pstmt.setInt(5, pvo.getPrice3());
				pstmt.setString(6, pvo.getContent());
				pstmt.setString(7, pvo.getImage());
				pstmt.setString(8, pvo.getSavefilename());
				pstmt.executeUpdate();
			} catch (SQLException e) {e.printStackTrace();
			} finally { Db.close(con, pstmt, rs); }
		}
		
}
