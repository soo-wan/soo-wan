<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

Connection con = null;
PreparedStatement pstmt = null;

String driver ="com.mysql.cj.jdbc.Driver";
String url ="jdbc:mysql://localhost:3306/scott";
String id ="root";
String pw ="adminuser";

String sql = "update members set name=?, pwd=?, phone=? where id=?";

String name = request.getParameter("name");
String pwd = request.getParameter("pwd");
String phone = request.getParameter("phone");
String updateid = request.getParameter("id");

//updateMember_do.jsp
//데이터베이스 연결하고, 전달된 내용을 레코드를 수정하세요

try{
		Class.forName(driver);
		con = DriverManager.getConnection(url, id, pw);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, pwd);
		pstmt.setString(3, phone);
		pstmt.setString(4, updateid);
		pstmt.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(con!=null) con.close();
			if(pstmt!=null) pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

response.sendRedirect("MemberMGR.jsp");

%>