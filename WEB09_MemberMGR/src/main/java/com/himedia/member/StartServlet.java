package com.himedia.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.himedia.member.dto.MemberDto;

public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//members 테이블의 내용을 조회해서, request에 담고 main.jsp로 forward 합니다
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String driver ="com.mysql.cj.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/scott";
		String id ="root";
		String pw ="adminuser";
		
		String sql = "select * from members";
		
		ArrayList<MemberDto> list = new ArrayList<>();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				MemberDto mdto = new MemberDto();
				//String userid = rs.getString("id");
				//mdto.setId(userid);
				mdto.setId(rs.getString("id"));
				mdto.setName(rs.getString("name"));
				mdto.setPwd(rs.getString("pwd"));
				mdto.setPhone(rs.getString("phone"));
				
				list.add(mdto);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		request.setAttribute("memberList", list);
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
