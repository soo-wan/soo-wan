<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 악세사리 </h2>
관심항목을 선택하세요.
<hr>
<form method="get" action="04_Checkbox_to.jsp">
	<input type="checkbox" name="item" value="shoes">신발
	<input type="checkbox" name="item" value="bag">가방
	<input type="checkbox" name="item" value="belt">벨트
	<br>
	<input type="checkbox" name="item" value="cap">모자
	<input type="checkbox" name="item" value="watch">시계
	<input type="checkbox" name="item" value="diamond">쥬얼리<br>
	<hr>
	<input type="radio" name="gender" value="M">남성
	<input type="radio" name="gender" value="F">여성
	<input type="submit" value="전송">
</body>
</html>