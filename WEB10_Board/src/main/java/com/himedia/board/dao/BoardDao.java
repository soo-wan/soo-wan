package com.himedia.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.himedia.board.dto.BoardDto;
import com.himedia.board.dto.MemberDto;
import com.himedia.board.dto.ReplyDto;
import com.himedia.board.util.Dbm;
import com.himedia.board.util.Paging;

public class BoardDao {
	private BoardDao() {}
	private static BoardDao itc = new BoardDao();
	public static BoardDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<BoardDto> getAllBoard(Paging paging){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		con = Dbm.getConnection();
		String sql = "select * from board order by num desc limit ? offset ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getDisplayRow());
			pstmt.setInt(2, paging.getStartNum() -1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDto bdto = new BoardDto();
				bdto.setNum(rs.getInt("num"));
				bdto.setPass(rs.getString("pass"));
				bdto.setEmail(rs.getString("email"));
				bdto.setUserid(rs.getString("userid"));
				bdto.setTitle(rs.getString("title"));
				bdto.setContent(rs.getString("content"));
				bdto.setReadcount(rs.getInt("readcount"));
				bdto.setWritedate(rs.getTimestamp("writedate"));
				bdto.setImage(rs.getString("image"));
				list.add(bdto);
			}
		} catch (SQLException e) { e.printStackTrace(); }
		finally { Dbm.close(con, pstmt, rs); }
		return list;
	}

	public void insertBoard(BoardDto bdto) {
		con = Dbm.getConnection();
		String sql = "insert into board(userid, pass, email, title, content, image, savefilename) "
				+ "values(?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getUserid());
			pstmt.setString(2, bdto.getPass());
			pstmt.setString(3, bdto.getEmail());
			pstmt.setString(4, bdto.getTitle());
			pstmt.setString(5, bdto.getContent());
			pstmt.setString(6, bdto.getImage());
			pstmt.setString(7, bdto.getSavefilename());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs); }
	}

	public void plusReadCount(int num) {
		con = Dbm.getConnection();
		String sql = "update board set readcount = readcount+1 where num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs); }
	}

	public BoardDto getBoard(int num) {
		BoardDto bdto = null;
		con = Dbm.getConnection();
		String sql = "select * from board where num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bdto = new BoardDto();
				bdto.setNum(rs.getInt("num"));
				bdto.setPass(rs.getString("pass"));
				bdto.setEmail(rs.getString("email"));
				bdto.setUserid(rs.getString("userid"));
				bdto.setTitle(rs.getString("title"));
				bdto.setContent(rs.getString("content"));
				bdto.setReadcount(rs.getInt("readcount"));
				bdto.setWritedate(rs.getTimestamp("writedate"));
				bdto.setImage(rs.getString("image"));
				bdto.setSavefilename(rs.getString("savefilename"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		finally { Dbm.close(con, pstmt, rs); }		
		return bdto;
	}

	public void updateBoard(BoardDto bdto) {
		con = Dbm.getConnection();
		String sql = "update board set pass=?, email=?, title=?, content=? "
				+ " ,image=?, savefilename=? where num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getPass());
			pstmt.setString(2, bdto.getEmail());
			pstmt.setString(3, bdto.getTitle());
			pstmt.setString(4, bdto.getContent());
			pstmt.setString(5, bdto.getImage());
			pstmt.setString(6, bdto.getSavefilename());
			pstmt.setInt(7, bdto.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs); }
	}

	public void deleteBoard(int num) {
		con = Dbm.getConnection();
		String sql = "delete from board where num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs); }
	}

	public ArrayList<ReplyDto> getReply(int num) {
		ArrayList<ReplyDto> list = new ArrayList<ReplyDto>();
		con = Dbm.getConnection();
		String sql = "select * from reply where boardnum=? order by replynum desc";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyDto rdto = new ReplyDto();
				rdto.setReplynum(rs.getInt("replynum"));
				rdto.setBoardnum(rs.getInt("boardnum"));
				rdto.setUserid(rs.getString("userid"));
				rdto.setContent(rs.getString("content"));
				rdto.setWritedate(rs.getTimestamp("writedate"));
				list.add(rdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs); }
		return list;
	}

	public void insertReply(ReplyDto rdto) {
		con = Dbm.getConnection();
		String sql = "insert into reply(boardnum, userid, content) values(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rdto.getBoardnum());
			pstmt.setString(2, rdto.getUserid());
			pstmt.setString(3, rdto.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs); }
	}

	public void deleteReply(int replynum) {
		con = Dbm.getConnection();
		String sql = "delete from reply where replynum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, replynum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { Dbm.close(con, pstmt, rs); }
	}

	public int getReplyCount(int num) {
		int count = 0;
		con = Dbm.getConnection();
		String sql = "select count(*) as cnt from reply where boardnum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) 
				count = rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally { Dbm.close(con, pstmt, rs); }
		return count;
	}

	public int getAllCount() {
		int count = 0;
		con = Dbm.getConnection();
		String sql = "select count(*) as cnt from board";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) 
				count = rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally { Dbm.close(con, pstmt, rs); }
		return count;
	}
}

