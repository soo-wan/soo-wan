package com.himedia.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.himedia.board.dto.MemberDto;
import com.himedia.board.util.Dbm;

public class MemberDao {

	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberDto getMember(String userid) {
		MemberDto mdto = null;
		con = Dbm.getConnection();
		String sql = "select * from member where userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mdto = new MemberDto();
				mdto.setUserid(rs.getString("userid"));
				mdto.setPwd(rs.getString("pwd"));
				mdto.setName(rs.getString("name"));
				mdto.setEmail(rs.getString("email"));
				mdto.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		finally { Dbm.close(con, pstmt, rs); }
		return mdto;
	}
	
	public int insertMember(MemberDto mdto) {
		int result = 0;
		con = Dbm.getConnection();
		String sql = "insert into member(userid, pwd, name, email, phone)"
				+ "values(?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getUserid());
			pstmt.setString(2, mdto.getPwd());
			pstmt.setString(3, mdto.getName());
			pstmt.setString(4, mdto.getEmail());
			pstmt.setString(5, mdto.getPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
		finally { Dbm.close(con, pstmt, rs); }
		return result;
	}

	public int updateMember(MemberDto mdto) {
		int result = 0;
		con = Dbm.getConnection();
		String sql = "update member set pwd=?, name=?, email=?, phone=? where userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getPwd());
			pstmt.setString(2, mdto.getName());
			pstmt.setString(3, mdto.getEmail());
			pstmt.setString(4, mdto.getPhone());
			pstmt.setString(5, mdto.getUserid());
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
		finally { Dbm.close(con, pstmt, rs); }
		return result;
	}

	public int deleteMember(String userid) {
		int result = 0;
		con = Dbm.getConnection();
		String sql = "delete from member where userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs); }
		return result;
	}
}
