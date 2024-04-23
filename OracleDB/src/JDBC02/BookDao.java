package JDBC02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//DAO : Data Access Object
public class BookDao {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userid = "scott";
	String pw = "tiger";
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close() {
		try {
			if(con!=null) con.close();
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Booklist 테이블의 모든 데이터를 리턴해주는 메서드
	//BookDto 에 레코드 하나씩 저장 -> BookDto 들이 ArrayList 저장되서 리턴
	public ArrayList<BookDto> getBooklist(){
		//데이터베이스에 연결
		con = getConnection();
		ArrayList<BookDto> list = new ArrayList<BookDto>();
		//테이블 내용 조회
		String sql = "select * from Booklist order by booknum desc"; //booknum 내림 차순
		
		//조회 내용을 정리해서 리턴
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) { //return 값이 true, false, 값이 없으면 false
				BookDto bdto = new BookDto();
				int booknum = rs.getInt("booknum");
				bdto.setBooknum(booknum);
				//변수에 안담고 그냥 한번에 dto에 resultset을 담음
				bdto.setSubject(rs.getString("subject"));
				bdto.setMakeyear(rs.getInt("makeyear"));
				bdto.setInprice(rs.getInt("inprice"));
				bdto.setRentprice(rs.getInt("rentprice"));
				bdto.setGrade(rs.getString("grade"));
				list.add(bdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 데이터베이스 연결 종료
		close();
		return list;
	}
	
	public int insertBook(BookDto bdto) {
		int result = 0;
		con = getConnection();
		String sql = "insert into booklist(booknum, subject, makeyear, inprice, rentprice, grade) "
				+ " values(book_seq.nextval, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, bdto.getSubject());
			pstmt.setInt(2, bdto.getMakeyear());
			pstmt.setInt(3, bdto.getInprice());
			pstmt.setInt(4, bdto.getRentprice());
			pstmt.setString(5, bdto.getGrade());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(); 
		}
		
		return result;
	}

	public BookDto getBook(int booknum) {
		BookDto bdto = null;
		con = getConnection();
		String sql = "select * from booklist where booknum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, booknum);
			rs = pstmt.executeQuery(); //검색된 결과가 1개거나 없거나, 그래서 if씀
			if(rs.next()) {
				bdto = new BookDto();
				bdto.setBooknum(rs.getInt("booknum"));
				bdto.setSubject(rs.getString("subject"));
				bdto.setMakeyear(rs.getInt("makeyear"));
				bdto.setInprice(rs.getInt("inprice"));
				bdto.setRentprice(rs.getInt("rentprice"));
				bdto.setGrade(rs.getString("grade"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return bdto;
	}

	public int updateBook(BookDto bdto) {
		int result = 0;
		con = getConnection();
		String sql = "update booklist set subject=?, makeyear=?, inprice=?, rentprice=?, grade=?"
				+ " where booknum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getSubject());
			pstmt.setInt(2, bdto.getMakeyear());
			pstmt.setInt(3, bdto.getInprice());
			pstmt.setInt(4, bdto.getRentprice());
			pstmt.setString(5, bdto.getGrade());
			pstmt.setInt(6, bdto.getBooknum());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return result;
	}

	public int deleteBook(int booknum) {
		int result = 0;
		con = getConnection();
		String sql = "delete from booklist where booknum =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, booknum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
}
