package JDBC03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBC02.BookDto;

public class MemberDao {
	DataBaseManager dbm = new DataBaseManager();
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<MemberDto> selectMember() {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		con = dbm.getConnection();
		
		String sql =  "select * from memberlist";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDto mdto = new MemberDto();
				mdto.setMembernum(rs.getInt("membernum"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBirth(rs.getDate("birth")); //SQL의 DATE 형식 -> Java.sqlDate
				mdto.setGender(rs.getString("gender"));
				mdto.setAge(rs.getInt("age"));
				mdto.setBpoint(rs.getInt("bpoint"));
				list.add(mdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbm.close(con, pstmt, rs);
		return list;
	}

	public int insertMember(MemberDto mdto) {
		int result = 0;
		con = dbm.getConnection();
		String sql = "insert into memberlist values(member_seq.nextval, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareCall(sql);
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setDate(3, mdto.getBirth());
			pstmt.setInt(4, mdto.getBpoint()); //안 받아도됨
			pstmt.setString(5, mdto.getGender());
			pstmt.setInt(6,mdto.getAge());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbm.close(con, pstmt, rs);
		return result;
	}

	public MemberDto getMember(int membernum) {
		MemberDto mdto = null;
		con = dbm.getConnection();
		String sql = "select * from memberlist where membernum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, membernum);
			rs = pstmt.executeQuery(); 
			if(rs.next()) {
				mdto = new MemberDto();
				mdto.setMembernum(rs.getInt("membernum"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBirth(rs.getDate("birth"));
				mdto.setGender(rs.getString("gender"));
				mdto.setAge(rs.getInt("age"));
				mdto.setBpoint(rs.getInt("bpoint"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbm.close(con, pstmt, rs);
		return mdto;
	}

	public int updateMember(MemberDto mdto) {
		int result = 0;
		con = dbm.getConnection();
		String sql = "update memberlist set name=?, phone=?, birth=?, age=?, bpoint=?, "
				+ " gender=? where membernum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setDate(3, mdto.getBirth());
			pstmt.setInt(4, mdto.getAge());
			pstmt.setInt(5, mdto.getBpoint());
			pstmt.setString(6, mdto.getGender());
			pstmt.setInt(7, mdto.getMembernum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbm.close(con, pstmt, rs);
		return result;
	}

	public int deleteMember(int membernum) {
		int result = 0;
		con = dbm.getConnection();
		String sql = "delete from memberlist where membernum =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, membernum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbm.close(con, pstmt, rs);
		return result;
	}
}
