package com.himedia.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.himedia.shop.dto.AdminVO;
import com.himedia.shop.dto.MemberVO;
import com.himedia.shop.dto.OrderVO;
import com.himedia.shop.dto.ProductVO;
import com.himedia.shop.dto.QnaVO;
import com.himedia.shop.util.Db;
import com.himedia.shop.util.Paging;

public class AdminDao {
	private AdminDao() {}
	private static AdminDao itc = new AdminDao();
	public static AdminDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public AdminVO getAdmin(String adminid) {
		AdminVO avo = null;
		con = Db.getConnection();
		String sql = "select * from admins where adminid=?"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				avo = new AdminVO();
				avo.setAdminid(rs.getString("adminid"));
				avo.setPwd(rs.getString("pwd"));
				avo.setName(rs.getString("name"));
				avo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
		return avo;
	}

	public ArrayList<ProductVO> adminProductList(Paging paging, String key) {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		con = Db.getConnection();
		String sql = "select * from product where name like concat('%', ?, '%') "
				+ " order by pseq desc limit ? offset ?"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getDisplayRow());
			pstmt.setInt(3, paging.getStartNum() -1 );
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice1(rs.getInt("price1")); //원가
				pvo.setPrice2(rs.getInt("price2")); //판매가
				pvo.setPrice3(rs.getInt("price3")); //마진
				pvo.setImage(rs.getString("image"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				list.add(pvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
		return list;
	}

	public int getAllCount(String tablename, String fieldname, String key) {
		int count = 0;
		con = Db.getConnection();
		String sql = "select count(*) as cnt from " + tablename 
				+ " where " + fieldname + " like concat('%', ?, '%') "; 
		// 검색어가 '부츠'  concat의 결과 '%부츠%' -> '부츠'를 포함한 상품명 검색
		// 검색어가 ''  concat의 결과 '%%' -> 모든 상품명을 결과로 검색
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
		return count;
	}

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

	public void updateProduct(ProductVO pvo) {
		con = Db.getConnection();
		String sql = "update product set kind=?, useyn=?, name=?, price1=?, "
				+ " price2=?, price3=?, content=?, bestyn=?, image=?, savefilename=? where pseq=?"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getKind());
			pstmt.setString(2, pvo.getUseyn());
			pstmt.setString(3, pvo.getName());
			pstmt.setInt(4, pvo.getPrice1());
			pstmt.setInt(5, pvo.getPrice2());
			pstmt.setInt(6, pvo.getPrice3());
			pstmt.setString(7, pvo.getContent());
			pstmt.setString(8, pvo.getBestyn());
			pstmt.setString(9, pvo.getImage());
			pstmt.setString(10, pvo.getSavefilename());
			pstmt.setInt(11, pvo.getPseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
	}

	public ArrayList<OrderVO> adminOrderList(Paging paging, String key) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		con = Db.getConnection();
		String sql = "select * from order_view "
				+ " where pname like concat('%', ?, '%') "
				+ " order by result, indate desc, odseq desc"
				+ " limit ? offset ?"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getDisplayRow());
			pstmt.setInt(3, paging.getStartNum()-1);
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

	public void updateOrderResult(int odseq) {
		con = Db.getConnection();
		String sql = "update order_detail set result = '2' where odseq=?"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, odseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
	}

//	public ArrayList<MemberVO> adminMemberList(Paging paging, String key) {
//		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
//		con = Db.getConnection();
//		String sql = "select * from member "
//				+ " where name like concat('%', ?, '%') "
//				+ " order by 1 desc "
//				+ " limit ? offset ?"; 
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, key);
//			pstmt.setInt(2, paging.getDisplayRow());
//			pstmt.setInt(3, paging.getStartNum()-1);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				MemberVO mvo = new MemberVO();
//				mvo.setUserid(rs.getString("userid"));
//				mvo.setName(rs.getString("name"));
//				mvo.setEmail(rs.getString("email"));
//				mvo.setZip_num(rs.getString("zip_num"));
//				mvo.setAddress1(rs.getString("address1"));
//				mvo.setAddress1(rs.getString("address2"));
//				mvo.setPhone(rs.getString("phone"));
//				mvo.setUseyn(rs.getString("useyn"));
//				mvo.setIndate(rs.getTimestamp("indate"));
//				list.add(mvo);
//			}
//		} catch (SQLException e) {e.printStackTrace();
//		} finally { Db.close(con, pstmt, rs); }
//		return list;
//	}
	
	//선생님꺼
	public ArrayList<MemberVO> adminMemberList(Paging paging, String key) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
	    String sql = "select * from member "
	          + " where name like concat('%', ? , '%') "
	          + " order by indate desc "
	          + " limit ? offset ?";
	    con = Db.getConnection();
	    try {
	       pstmt = con.prepareStatement(sql);
	       pstmt.setString(1, key);
	       pstmt.setInt(2,  paging.getDisplayRow() );
	       pstmt.setInt(3,  paging.getStartNum()-1);
	       rs = pstmt.executeQuery();
	       while(rs.next()) {
	          MemberVO mvo = new MemberVO();
	          mvo.setUserid( rs.getString("userid") );
	          mvo.setPwd(rs.getString("pwd"));
	            mvo.setName(rs.getString("name"));
	            mvo.setEmail(rs.getString("email"));
	            mvo.setZip_num(rs.getString("zip_num"));
	            mvo.setAddress1(rs.getString("address1"));
	            mvo.setAddress2(rs.getString("address2"));
	            mvo.setPhone(rs.getString("phone"));
	            mvo.setUseyn(rs.getString("useyn"));
	            mvo.setIndate(rs.getTimestamp("indate"));
	          
	          list.add(mvo);
	       }
	    } catch (SQLException e) { e.printStackTrace();
	    } finally { Db.close(con, pstmt, rs);  }
	    return list;
	}

	public ArrayList<QnaVO> adminQnaList(Paging paging, String key) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		String sql = "select * from qna "
				+ " where subject like concat('%', ?, '%') "
				+ " order by qseq desc limit ? offset ?";
		con = Db.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
	        pstmt.setInt(2,  paging.getDisplayRow() );
	        pstmt.setInt(3,  paging.getStartNum()-1);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVO qvo = new QnaVO();
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setReply(rs.getString("reply"));
				qvo.setUserid(rs.getString("userid"));
				qvo.setIndate(rs.getTimestamp("indate"));
				list.add(qvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
		return list;
	}

	public void qnaReplyUpdate(int qseq, String reply) {
		con = Db.getConnection();
		String sql = "update qna set reply = ? where qseq=?"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reply);
			pstmt.setInt(2, qseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
	}
}
