<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 오늘날짜 발생 및 변수에 저장 -->
<c:set var="now" value="<%=new java.util.Date()%>"></c:set>

<!-- 일반적인 출력 -->
<h2>\${now} : ${now}</h2>

<!-- JSTL 포멧팅에 의한 출력 -->
<h2>
<fmt:formatDate value="${now}" /><br>
<fmt:formatDate value="${now}" type="date" /><br>
<fmt:formatDate value="${now}" type="time" /><br>
<fmt:formatDate value="${now}" type="both" /><br>
</h2>

<br><br><br>
<h2>
<fmt:formatDate value="${now}" type="both" dateStyle="default" timeStyle="default" /><br>
<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short" /><br>
<fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium" /><br>
<fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long" /><br>
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /><br>
</h2>

<br><br><br>
<h2>
pattern="yyyy년 MM월 dd일 hh시 mm분 ss초" : <br>
<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초" /><br>
</h2>
</body>
</html>