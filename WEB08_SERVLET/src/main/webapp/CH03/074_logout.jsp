<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//로그인 정보의 삭제
//session.removeAttribute("loginUser");
//현재 사이트의 모든 세션을 삭제
session.invalidate();
//response.sendRedirect("071_LoginForm.jsp");
%>
<script type="text/javascript">
	alert("로그아웃되었습니다");
	location.href='071_LoginForm.jsp';
</script>