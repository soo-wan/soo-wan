package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentDao {
	private RentDao() {}
	private static RentDao itc = new RentDao();
	public static RentDao getInstance() {
		return itc;
	}
	
	//Dbman db = new Dbman();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public ArrayList<RentDto> selectRent() {
		ArrayList<RentDto> list = new ArrayList<RentDto>();
		con = Dbman.getConnection();
		
		String sql = "select * from rentDetail order by numseq desc"; //view 생성후 select
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				RentDto rdto = new RentDto();
				rdto.setNumseq(rs.getInt("numseq"));
				rdto.setRentdate(rs.getString("rd"));
				rdto.setBnum(rs.getInt("bnum"));
				rdto.setSubject(rs.getString("subject"));
				rdto.setMnum(rs.getInt("mnum"));
				rdto.setName(rs.getString("name"));
				rdto.setRentprice(rs.getInt("rentprice"));
				rdto.setDiscount(rs.getInt("discount"));
				rdto.setAmount(rs.getInt("amount"));
				list.add(rdto);
			}
		} catch (SQLException e) { e.printStackTrace(); } 
		  finally { Dbman.close(con, pstmt, rs);}
		return list;
	}
	public int memberOk(String membernum) {
		int result = 0;
		con = Dbman.getConnection();
		//String sql = "select count(*) as cnt from memberlist where membernum=?";
		String sql = "select * from memberlist where membernum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(membernum));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//result = rs.getInt("cnt");
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return result;
	}
	public int bookOk(String booknum) {
		int result = 0;
		con = Dbman.getConnection();
		String sql = "select * from booklist where booknum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(booknum));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return result;
	}
	
	public int insertRent(RentDto rdto) {
		int result = 0;
		con = Dbman.getConnection();
		String sql = "insert into rentlist(bnum, mnum, discount) " 
				+ " values(?, ?, ?);";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rdto.getBnum());
			pstmt.setInt(2, rdto.getMnum());
			pstmt.setInt(3, rdto.getDiscount());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return result;
	}
	
	public RentDto getRent(int numseq) {
		RentDto rdto = null;
		con = Dbman.getConnection();
		String sql = "select * from rentDetail where numseq = ?"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, numseq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rdto = new RentDto();
				rdto.setNumseq(rs.getInt("numseq"));
				rdto.setRentdate(rs.getString("rd"));
				rdto.setBnum(rs.getInt("bnum"));
				rdto.setSubject(rs.getString("subject"));
				rdto.setMnum(rs.getInt("mnum"));
				rdto.setName(rs.getString("name"));
				rdto.setRentprice(rs.getInt("rentprice"));
				rdto.setDiscount(rs.getInt("discount"));
				rdto.setAmount(rs.getInt("amount"));
			}
		} catch (SQLException e) { e.printStackTrace(); } 
		  finally { Dbman.close(con, pstmt, rs);}
		return rdto;
	}
	
	public int updateRent(RentDto rdto) {
		int result = 0;
		con = Dbman.getConnection();
		String sql = "update rentlist set rentdate=str_to_date(concat('', ?, ''), '%Y-%m-%d'), " //날짜에 ''붙이려고 concat, 나중에 like쓸때도 마찬가지 concat('%' , ? , '%')
				+ " bnum=?, mnum=?, discount=? where numseq=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rdto.getRentdate());
			pstmt.setInt(2, rdto.getBnum());
			pstmt.setInt(3, rdto.getMnum());
			pstmt.setInt(4, rdto.getDiscount());
			pstmt.setInt(5, rdto.getNumseq());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return result;
	}
	public int deleteRent(int numseq) {
		int result = 0;
		con = Dbman.getConnection();
		String sql = "delete from rentlist where numseq=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, numseq);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return result;
	}
}
