<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
//deleteMember.jsp
// 스크립트를 이용해서 정말로 삭제할까요? 라고 물어보고 확인 삭제, 취소는 원래데로 돌아가도록 합니다
// 삭제가완료되면 MemberMGR.jsp 로가기전에  삭제가 완료되었습니다 라고 경고창을 보여주세요
%>
<script type="text/javascript">
var ans = confirm("정말로 삭제하시겠습니까?");
if(!ans)history.go(-1);
</script>

<%
Connection con = null;
PreparedStatement pstmt = null;

String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/scott";
String id="root";
String pw="adminuser";

String userid = request.getParameter("id");
String sql = "delete from members where id=?";

try{
   Class.forName(driver);
   con = DriverManager.getConnection(url, id, pw);
   pstmt = con.prepareStatement(sql);
   pstmt.setString(1, userid);
   pstmt.executeUpdate();
}catch(Exception e){   e.printStackTrace();
}finally{
   try {      if (pstmt != null) pstmt.close();
            if (con != null)   con.close();
   } catch (Exception e) {   e.printStackTrace();   }
}
%>

<script type="text/javascript">
	alert("삭제가 완료되었습니다.");
	location.href='MemberMGR.jsp';
</script>