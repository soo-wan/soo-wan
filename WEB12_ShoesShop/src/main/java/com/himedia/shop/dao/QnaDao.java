package com.himedia.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.himedia.shop.dto.AddressVO;
import com.himedia.shop.dto.QnaVO;
import com.himedia.shop.util.Db;
import com.himedia.shop.util.Paging;

public class QnaDao {
	private QnaDao() {}
	private static QnaDao itc = new QnaDao();
	public static QnaDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<QnaVO> selectQna(Paging paging) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		String sql = "select * from qna order by qseq desc limit ? offset ?";
		con = Db.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getDisplayRow());
			pstmt.setInt(2, paging.getStartNum() -1);
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

	public QnaVO getQna(int qseq) {
		QnaVO qvo = new QnaVO();
		String sql = "select * from qna where qseq = ?";
		con = Db.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				qvo.setQseq(qseq);
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setReply(rs.getString("reply"));
				qvo.setUserid(rs.getString("userid"));
				qvo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
		return qvo;
	}

	public void insertQna(QnaVO qvo) {
		String sql = "insert into qna(subject, content, userid) values(?,?,?)";
		con = Db.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getSubject());
			pstmt.setString(2, qvo.getContent());
			pstmt.setString(3, qvo.getUserid());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Db.close(con, pstmt, rs); }
	}

	public int getAllCount() {
		int count = 0;
		con = Db.getConnection();
		String sql = "select count(*) as cnt from qna";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) 
				count = rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally { Db.close(con, pstmt, rs); }
		return count;
	}

	public int getReplyCount(Integer qseq) {
		int count = 0;
		con = Db.getConnection();
		String sql = "select count(*) as cnt from qna where qseq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if(rs.next()) 
				count = rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally { Db.close(con, pstmt, rs); }
		return count;
	}
}
