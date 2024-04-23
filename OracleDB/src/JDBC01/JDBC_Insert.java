package JDBC01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Insert {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String id = "scott";
		String pw = "tiger";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			Scanner sc = new Scanner(System.in);
			System.out.print("번호를 입력하세요 :");
			int num = Integer.parseInt(sc.nextLine());
			System.out.print("이름을 입력하세요 :");
			String name = sc.nextLine();
			System.out.print("이메일을 입력하세요 :");
			String email = sc.nextLine();
			System.out.print("전화번호를 입력하세요 :");
			String phone = sc.nextLine();
			
			//String sql = insert into customer values(6, '김하나', 'abc5@abc.com', '010-4444-5555')";
			//옛날 방식
			//String sql = "insert into customer values(" +num+", "+name+","+email +"," + phone +")"; 
			
			//요즘 방식
			String sql = "insert into customer values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, phone);
			//setInt와 setString이 자동으로 필요한 따옴표(' ')를 붙여서 sql 명령을 구성하여 줍니다
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) System.out.println("레코드 추가 성공");
			else System.out.println("레코드 추가 실패");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
