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
	response.sendRedirect("board.do?command=loginForm");
	/* 
		-클라이언트와 서버가 request와 response를 이용해서 연결하고 통신하는 곳이 Servlet 입니다
		-이전 단원에서는 매 페이지마다 해당 서블릿을 만들고, 각 페이지를 보기 위해서 담당 서블릿을 호출하는 형식
		-그로인해서 서블릿의 URL Mapping들이 노출되지만 이외것들은 모두 감춰지는 효과를 볼수있다.
		-이번 단원에서는 서블릿을 하나로 단축하고, command라는 파라미터를 써서 각 페이지 호출을 구분할 예정
		-현재의 구조에서는 단일 서블릿 내에서 기능별로 구성된 클래스들을 이용한 기능 구현을 하게 된다.
		-이 구조가 기능마다 서블릿이 있는것보다 구조가 간편하고 서버의 부담을 줄이게 된다.
	*/
%>
</body>
</html>