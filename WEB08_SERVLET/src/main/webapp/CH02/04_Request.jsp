<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
Request : 주로 서버에서 정보를 요청할 때 사용하는 객체이며, 객체의 각 정보들을 이용하여 사이트에 유용한
설정 및 실행에 이용합니다(자료형: HttpServletRequest)
 -->

<!-- request 객체가 담고 있는 정보들 -->
<h2>
컨텍스트 패스 : <%= request.getContextPath() %> <br>
요청방식 : <%= request.getMethod() %> <br>
요청한 URL : <%= request.getRequestURL() %> <br>
요청한 URI : <%= request.getRequestURI() %> <br>
서버의 이름 : <%= request.getServerName() %> <br>
프로토콜 : <%= request.getProtocol() %> <br>
</h2>
</body>
</html>