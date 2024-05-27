<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%!
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String driver ="com.mysql.cj.jdbc.Driver";
	String url ="jdbc:mysql://localhost:3306/scott";
	String id ="root";
	String pw ="adminuser";
	
	String sql = "select * from members";
%>
</head>
<body>
<table width="800" bgcolor="black" cellspacing="1">
	<tr bgcolor="white">
		<th>아이디</th><th>암호</th><th>이름</th><th>전화번호</th><th>수정</th><th>삭제</th>
	</tr>
<%
	try{
		Class.forName(driver);
		con = DriverManager.getConnection(url, id, pw);
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			out.print("<tr bgcolor='white'>");
			
			out.print("<td align='center'>" + rs.getString("id") +"</td>");
			out.print("<td align='center'>" + rs.getString("pwd") +"</td>");
			out.print("<td align='center'>" + rs.getString("name") +"</td>");
			out.print("<td align='center'>" + rs.getString("phone") +"</td>");
			out.print("<td align='center'>"
			+ "<input type='button' value='수정' " 
			+ "onclick='location.href=\"updateForm.jsp?id=" + rs.getString("id") +"\" '></td>");
			out.print("<td align='center'>"
					+ "<input type='button' value='삭제' " 
					+ "onclick='location.href=\"deleteMember.jsp?id=" + rs.getString("id") +"\" '></td>");
			out.print("</tr>");
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(con!=null) con.close();
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
</table>
<a href="InsertForm.jsp">멤버추가</a>
</body>
</html>