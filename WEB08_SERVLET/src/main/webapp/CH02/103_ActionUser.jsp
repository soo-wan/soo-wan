<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLDecoder" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//String userName = request.getParameter("name"); //response.sendRedirect로 전송된 경우
//String userName = (String)request.getAttribute("name"); // forward한 경우
String userName = URLDecoder.decode(request.getParameter("name"), ("UTF-8"));
%>

<h2><%=userName %>(<%=request.getParameter("userID") %>)님 환영합니다</h2>
</body>
</html>