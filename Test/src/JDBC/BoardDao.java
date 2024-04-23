package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {
	private BoardDao() {}
	private static BoardDao itc = new BoardDao();
	public static BoardDao getInstance() {
		return itc;
	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<BoardDto> selectBoard() {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		con = Dbman.getConnection();
		String sql = "select * from boardDetail order by boardnum desc"; 
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto bdto = new BoardDto();
				bdto.setBoardnum(rs.getInt("boardnum"));
				bdto.setWriter(rs.getString("writer"));
				bdto.setSubject(rs.getString("subject"));
				bdto.setContent(rs.getString("content"));
				bdto.setWritedate(rs.getString("writedate"));
				bdto.setReadcount(rs.getInt("readcount"));
				bdto.setName(rs.getString("name"));
				bdto.setEmail(rs.getString("email"));
				list.add(bdto);
			}
		} catch (SQLException e) { e.printStackTrace(); } 
		  finally { Dbman.close(con, pstmt, rs);}
		return list;
	}
}
