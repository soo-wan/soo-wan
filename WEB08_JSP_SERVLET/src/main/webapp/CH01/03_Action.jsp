<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<form method="get" action="03_Action_to.jsp" name="joinForm">
	<!-- 
		- form 태그내의 submit 버튼을 누르면 form에 입력한 입력사항들이 name 과 value 로 쌍을
		이뤄서 action 에 지정한 곳으로 전송됩니다. action 지정되는 곳은 서버내의 특정 페이지 또는 서블릿들이 지정될 수 있습니다.
		- action : 입력한 데이터들이 전송되어질 목적지
		- method : get 을 지정하면 url 속에 데이터가 노출되고, post를 지정하면 url 속에 데이터가
						나타나지 않습니다. 따로 쓰지 않으면 get 입니다
	 -->
	 <laver for="name"> 이름 </laver><input type="text"id="name" name="name"><br>
	 <laver for="id"> 아이디  </laver><input type="text" name="id"><br>
	 <laver for="pwd"> 비밀번호  </laver><input type="password"id="pwd" name="pwd"><br>
	 <laver for="pwd_re"> 비밀번호 확인  </laver>
	 	<input type="password"id="pwd_re" name="pwd_re"><br>
	 <input type="submit" value="회원가입">
	 <input type="hidden" name="email" value="hong2@naver.com">	
	 
	 	
</form>

</body>
</html>