<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05_JSTL_WHEN.jsp</title>
</head>
<body>

<c:choose>
   <c:when test="${param.fruit==1}"> <!-- ?fruit=1 -->
      <span style="color: red; font-size:180%; font-weight:bold;">사과</span>
   </c:when>
   <c:when test="${param.fruit==2}">
      <span style="color: green; font-size:180%; font-weight:bold;">멜론</span>
   </c:when>
   <c:when test="${param.fruit==3}">
      <span style="color: blue; font-size:180%; font-weight:bold;">수박</span>
   </c:when>
   <c:otherwise>
      <span style="color: silver; font-size:180%; font-weight:bold;">기타</span>
   </c:otherwise>
</c:choose>
</body>
</html>