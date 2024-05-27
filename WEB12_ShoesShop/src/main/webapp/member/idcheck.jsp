<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<h2>ID 중복확인</h2>
<form method="post" name="idCheckForm" action="shop.do?command=idcheckForm">
	User ID : <input type="text" name="userid" value="${userid}">
	<input type="submit" value="검색"><br><br><br>
</form>
<div>
	<c:if test="${result==1}">
		<script type="text/javascript">
			opener.document.joinForm.userid.value="";
			opener.document.joinForm.reid.value="";
		</script>
		${userid}는 이미 사용중인 아이디입니다.
	</c:if>
	<c:if test="${result == -1}">
		${userid}는 사용 가능한 ID입니다.
		<input type="button" value="사용할께요" onclick="idok('${userid}')">
	</c:if>
</div>
</body>
</html>