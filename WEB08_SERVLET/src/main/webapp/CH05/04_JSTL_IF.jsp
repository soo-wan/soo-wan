<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.himedia.servlet.dto.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
c:if  test 조건절에 참이면 /c:if 까지의 내용을 웹페이지에 적용 또는 표시하고
아니면 표시-적용 없이 지나갑니다. test안의 조건식은 EL 문법을 이용
 -->
 
 <c:if test="${param.color==1}">
 	<span style="color: red; font-size:180%;">
 </c:if>
</body>
</html>