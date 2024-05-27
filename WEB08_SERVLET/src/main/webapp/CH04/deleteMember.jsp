<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<!-- deleteMember.jsp
스크립트를 이용해서 정말로 삭제할까요?라고 물어보고 확인 삭제, 
취소는 원래대로 돌아가도록 합니다.
삭제가 완료되면 MemberMGR.jsp로 가기전에 삭제가 완료되었습니다 라고 
경고창을 보여주세요 -->

<script type="text/javascript">
 	var result = confirm("정말로 삭제할까요?");
 	
 	console.log(result);
 	
	if (!result) {
		window.location.href = "MemberMGR.jsp";
	} 
</script>

<%

Connection con = null;
PreparedStatement pstmt = null;

String driver ="com.mysql.cj.jdbc.Driver";
String url ="jdbc:mysql://localhost:3306/scott";
String id ="root";
String pw ="adminuser";

String sql = "delete from members where id=?";

String deleteid = request.getParameter("id");

try{
		Class.forName(driver);
		con = DriverManager.getConnection(url, id, pw);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, deleteid);
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
 %>
  <script type="text/javascript">
	alert("삭제가 완료되었습니다.");
	location.href='MemberMGR.jsp';
</script>