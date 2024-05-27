<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(session.getAttribute("loginUser") == null){
		response.sendRedirect("071_LoginForm.jsp");
	}else{
		out.print("<h2>" 
			    + session.getAttribute("loginUser") + "(" 
				+ session.getAttribute("name") + ")님이 로그인하셨습니다</h2>");
	}
%>
<input type="button" value="로그아웃" onclick="location.href='074_logout.jsp'">
</body>
</html>