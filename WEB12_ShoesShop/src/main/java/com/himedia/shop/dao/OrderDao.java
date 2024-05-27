package com.himedia.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.himedia.shop.dto.CartVO;
import com.himedia.shop.dto.OrderVO;
import com.himedia.shop.util.Db;

public class OrderDao {
	private OrderDao() {}
	private static OrderDao itc = new OrderDao();
	public static OrderDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertOrders(String userid) {
		con = Db.getConnection();
		String sql = "insert into orders(userid) values(?)"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
	}

	public int looupMaxOseq(String userid) {
		int oseq = 0;
		con = Db.getConnection();
		String sql = "select max(oseq) as moseq from orders where userid=?"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) oseq = rs.getInt("moseq");
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
		return oseq;
	}

	public void insertOrderDetail(CartVO cvo, int oseq) {
		con = Db.getConnection();
		String sql = "insert into order_detail(oseq, pseq, quantity) values(?, ?, ?)"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, oseq);
			pstmt.setInt(2, cvo.getPseq());
			pstmt.setInt(3, cvo.getQuantity());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
	}

	public ArrayList<OrderVO> selectOrderByOseq(int oseq) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		con = Db.getConnection();
		String sql = "select * from order_view where oseq=?"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, oseq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderVO ovo = new OrderVO();
				ovo.setOdseq(rs.getInt("odseq"));
				ovo.setOseq(rs.getInt("oseq"));
				ovo.setUserid(rs.getString("userid"));
				ovo.setIndate(rs.getTimestamp("indate"));
				ovo.setMname(rs.getString("mname"));
				ovo.setZip_num(rs.getString("zip_num"));
				ovo.setAddress1(rs.getString("address1"));
				ovo.setAddress2(rs.getString("address2"));
				ovo.setPhone(rs.getString("phone"));
				ovo.setPname(rs.getString("pname"));
				ovo.setPrice2(rs.getInt("price2"));
				ovo.setPseq(rs.getInt("pseq"));
				ovo.setQuantity(rs.getInt("quantity"));
				ovo.setResult(rs.getString("result"));
				list.add(ovo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
		return list;
	}

	public void insertOrderDetail(int oseq, int pseq, int quantity) {
		con = Db.getConnection();
		String sql = "insert into order_detail(oseq, pseq, quantity) values(?, ?, ?)"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, oseq); 
			pstmt.setInt(2, pseq);
			pstmt.setInt(3, quantity);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
	}

	public ArrayList<Integer> selectOseqOrderIng(String userid) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		con = Db.getConnection();
		String sql = "select distinct oseq from order_view "
				+ " where userid=? and result='1' order by oseq desc "; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid); 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt("oseq"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
		return list;
	}

	public ArrayList<Integer> selectOseqOrderAll(String userid) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		con = Db.getConnection();
		String sql = "select distinct oseq from order_view "
				+ " where userid=? order by oseq desc "; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid); 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt("oseq"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
		return list;
	}
}
