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

<fmt:setLocale value="ko_KR" />
<h3>로케일을 한국으로 설정후 로케일 확인 : <%=response.getLocale() %></h3>

<h3>
통화(currency) : <fmt:formatNumber value="10000" type="currency" /><br>
숫자(number) : <fmt:formatNumber value="1000.1234" type="number" maxFractionDigits="2" /><br>
</h3>

<h3>
<fmt:setLocale value="en_US" />
로케일을 영어로 설정후 로케일 확인 : <%=response.getLocale()%><br>
통화(currency): <fmt:formatNumber value="10000" type="currency" /><br>
</h3>

<h3>
<fmt:setLocale value="ja_JP" />
로케일을 일본어로 설정후 로케일 확인 : <%=response.getLocale()%><br>
통화(currency): <fmt:formatNumber value="10000" type="currency" /><br>
</h3>
</body>
</html>