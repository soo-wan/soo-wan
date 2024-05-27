<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>
<%= request.getAttribute("name") %>(<%=request.getParameter("id") %>)님이 로그인 하셨습니다
</h1>
<h1>저희 사이트에 방문해 주셔서 감사합니다</h1>
</body>
</html>