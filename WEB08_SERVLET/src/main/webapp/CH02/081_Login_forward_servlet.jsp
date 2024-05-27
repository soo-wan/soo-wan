<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 서블릿과 포원드를 이용한 로그인 처리(데이터 베이스 미연동) -->
<form method="post" action="../login.do">
	<label for="userid"> 아이디 : </label><input type="text" name="id"><br>
	<label for="pwd">암 &nbsp; 호 : </label><input type="password" name="pwd"><br>
	<input type="submit" value="로그인">
</form>
<!-- 
정보입력 페이지(jsp) -> 정보처리페이지(jsp) -> 처리결과페이지(jsp)
이 세단계를 거친 자료처리방식은 옛날 방식입니다.
주로 윈도우 서버(Window NT)에서 ASP 언어를 사용할 때 많이 사용하던 방식입니다.

WEB 서버 : IIS, nginx 등 	클라이언트와 서버간 요청과 응답만 있는 통신 웹서버
WAS : WEB APPLICATION SERVER, 프로그래밍 언어의 컴파일과 실행기능이 같이 탑재된 서버.
			(톰캣, Web Logic, JBoss)
			
현재 로그인 구조는 WAS 서버를 이용할 예정이고, 서블릿을 이용한 처리를 할 예정입니다.
정보처리페이지(jsp)는 사용하지 않습니다.
 -->

</body>
</html>