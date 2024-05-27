<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="052_Login_do.jsp">
	<label for="id">아이디 : </label><input type="text" name="id"><br>
	<label for="pwd">암 &nbsp; 호 : </label><input type="password" name="pwd"><br>
	<input type="submit" value="로그인">
	</form>
	<!-- 
		1. 로그인 순서
			아이디와 암호 입력후 submit 버튼 클릭 -> 입력된 아이디와 암호가 서버로 전송
			-> 전송된 아이디로 데이터베이스 검색 -> 검색 결과에 따라 로그인실패 또는 성공을 경우로 나눠서 프론트에서 표시
			; 검색된 아이디가 없으면 " 아이디가 없습니다" 아이디가 있으면서 암호가 틀리면 "암호가 틀립니다"
			; 아이디도 있고 암호도 일치하면 로그인 성공
			
		2. 아이디와 암호의 검색 및 검증은 보통 서법내부에서 JAVA 프로그래밍으로 이루어집니다.
		3. 자바프로그래밍을 할 수 있게 해주는 주체를 흔히 서블릿이라고 부릅니다.
		4. 보통 form에서 action 에는 로그인 검증을 담당하는 서블릿을 지정합니다.
		5. 서블릿은 웹용 클래스라고 생각해도 무방합니다.
		
		6. 지금은 서블릿도 웹클래스도 학습하지 않은 상태라서 그 역할을 052_Login_do.jsp 파일이 하도록 하겠습니다.
		7. 데이터베이스도 아직 연동하기 전이니 유효한 아이디 / 비번은 scott/1234 로 하겠습니다.
	 -->
</body>
</html>