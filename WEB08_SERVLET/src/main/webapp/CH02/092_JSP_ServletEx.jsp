<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>환영합니다!!!!!!!!!</h1>

<h3>
아이디 : <%= request.getAttribute("id") %><p>
비밀번호 : <%= request.getAttribute("pwd") %><p>
성별 : <%= request.getAttribute("gender") %><p>
가입인사 : <%= request.getAttribute("content") %><p>

<% String [] itemName = (String [])request.getAttribute("item");  %>
구입 하신 상품 : 
<% 
for(String item : itemName)
		out.print(item + " ");
%><p>

직업 : <%= request.getAttribute("job") %><p>
</h3>
<!-- : = request.getAttribute("item") -->

<h1>저희 사이트에 방문해 주셔서 감사합니다</h1>
</body>
</html>