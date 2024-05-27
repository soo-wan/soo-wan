package com.himedia.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.himedia.shop.dto.AddressVO;
import com.himedia.shop.dto.CartVO;
import com.himedia.shop.util.Db;

public class CartDao {
	private CartDao() {}
	private static CartDao itc = new CartDao();
	public static CartDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertCart(CartVO cvo) {
		con = Db.getConnection();
		String sql = "insert into cart(quantity,pseq,userid) values(?,?,?)"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cvo.getQuantity());
			pstmt.setInt(2, cvo.getPseq());
			pstmt.setString(3, cvo.getUserid());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
	}

	public ArrayList<CartVO> selectCart(String userid) {
		ArrayList<CartVO> list = new ArrayList<CartVO>();
		con = Db.getConnection();
		String sql = "select * from cart_view where userid=?";  
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartVO cvo = new CartVO();
				cvo.setCseq(rs.getInt("cseq"));
				cvo.setUserid(rs.getString("userid"));
				cvo.setMname(rs.getString("mname"));
				cvo.setPseq(rs.getInt("pseq"));
				cvo.setPname(rs.getString("pname"));
				cvo.setQuantity(rs.getInt("quantity"));
				cvo.setPrice2(rs.getInt("price2"));
				cvo.setIndate(rs.getTimestamp("indate"));
				list.add(cvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
		return list;
	}

	public void deleteCart(int cseq) {
		con = Db.getConnection();
		String sql = "delete from cart where cseq=?";  
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
	}

	public CartVO getCart(String cseq) {
		CartVO cvo = new CartVO();
		con = Db.getConnection();
		String sql = "select * from cart_view where cseq = ?";  
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cseq));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cvo.setCseq(rs.getInt("cseq"));
				cvo.setUserid(rs.getString("userid"));
				cvo.setMname(rs.getString("mname"));
				cvo.setPseq(rs.getInt("pseq"));
				cvo.setPname(rs.getString("pname"));
				cvo.setQuantity(rs.getInt("quantity"));
				cvo.setPrice2(rs.getInt("price2"));
				cvo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
		return cvo;
	}
}
