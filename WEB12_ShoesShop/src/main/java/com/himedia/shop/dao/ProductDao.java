package com.himedia.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.himedia.shop.dto.ProductVO;
import com.himedia.shop.util.Db;

public class ProductDao {

	
		private ProductDao() {}
		private static ProductDao itc = new ProductDao();
		public static ProductDao getInstance() {return itc;}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		public ArrayList<ProductVO> bestList() {
			ArrayList<ProductVO> list = new ArrayList<ProductVO>();
			con = Db.getConnection();
			String sql = "select * from best_pro_view";
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()){
				ProductVO pvo = new ProductVO(); 
				pvo.setPseq( rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setImage( rs.getString("image"));
				list.add(pvo);
			}
			} catch (SQLException e) { e.printStackTrace();
			}finally{ Db.close(con, pstmt, rs); } 
			return list;
		}
		public ArrayList<ProductVO> newList() {
			ArrayList<ProductVO> list = new ArrayList<ProductVO>();
			con = Db.getConnection();
			String sql = "select * from new_pro_view";
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()){
				ProductVO pvo = new ProductVO(); 
				pvo.setPseq( rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setImage( rs.getString("image"));
				list.add(pvo);
			}
			} catch (SQLException e) { e.printStackTrace();
			}finally{ Db.close(con, pstmt, rs); } 
			return list;
		}
		
		public ArrayList<ProductVO> selectKindProduct(String kind) {
			ArrayList<ProductVO> list = new ArrayList<ProductVO>();
			con = Db.getConnection();
			String sql = "select * from product where kind=?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, kind);
				rs = pstmt.executeQuery();
				while(rs.next()){
				ProductVO pvo = new ProductVO(); 
				pvo.setPseq( rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setImage( rs.getString("image"));
				pvo.setSavefilename(rs.getString("savefilename"));
				list.add(pvo);
			}
			} catch (SQLException e) { e.printStackTrace();
			}finally{ Db.close(con, pstmt, rs); } 
			return list;
		}
		public ProductVO getProduct(int pseq) {
			ProductVO pvo = new ProductVO();
			con = Db.getConnection();
			String sql = "select * from product where pseq=?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, pseq);
				rs = pstmt.executeQuery();
				if(rs.next()){
				pvo.setPseq( rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setKind(rs.getString("kind"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setContent(rs.getString("content"));
				pvo.setImage( rs.getString("image"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setSavefilename(rs.getString("savefilename"));
			}
			} catch (SQLException e) { e.printStackTrace();
			}finally{ Db.close(con, pstmt, rs); } 
			return pvo;
		}
}
