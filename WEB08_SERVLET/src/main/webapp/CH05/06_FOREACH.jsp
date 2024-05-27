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
<%
	String [] movieList = {"타이타닉", "시네마 천국", "혹성 탈출", "킹콩"};
	//배열을 만들고 만든 배열을 request의 Attribute에 저장
	request.setAttribute("mList", movieList);
	//서버에서 JSP 파일로 전달되는 배열이나 ArrayList는 보통 request의 Attribute에 담겨온다
	//이를 바로 반복실행문에 적용하는 형식이 주로 사용된다.
	//그래서 배열을 만들고 마든 배열을 request에 저장했습니다.
	
	//전달된 배열을 JSP로 꺼내서 출력한다면
	String [] mlist = (String []) request.getAttribute("mList");
	for(String s : mlist)
		out.print("<h2>" + s + "</h2>");
%>
<br><br>

<!-- JSTL과 EL 그리고 배열을 이용한 반복실행 -->
<c:forEach items="${mlist}" var="s">
	<h2>${s}</h2>
</c:forEach>

<!-- 
	items="" : 반복실행헤 이용할 리스트 또는 배열을 지정(request나 session에 저장된 키값)
	var="s" : 배열 또는 리스트의 값을 한번에 하나씩 저장할때 사용할 변수 이름
 -->
 
 <br><br><hr><br><br>
 <table border="1" style="width:700px; text-align:center">
 	<tr>
 		<th>index</th><th>count</th><th>title</th>
 	</tr>
 	<c:forEach items="${mList}" var="movie" varStatus="state">
 		<c:choose>
 			<c:when test="${state.first}">
 				<tr style="font-weight : bold; color:red;">
 					<td>${state.index}</td><td>${state.count}</td><td>${movie}</td>
 				</tr>
 			</c:when>
 			<c:when test="${state.last}">
 				<tr style="font-weight : bold; color:blue;">
 					<td>${state.index}</td><td>${state.count}</td><td>${movie}</td>
 				</tr>
 			</c:when>
 			<c:otherwise>
 				<tr style="font-weight : bold; color:black;">
 					<td>${state.index}</td><td>${state.count}</td><td>${movie}</td>
 				</tr>
 			</c:otherwise>
 		</c:choose>
 	</c:forEach>
 </table>
</body>
<!-- 
varStatus : 반복실행의 상태값을 갖고 있는 클래스
status : 현재 반복순서 객체 변수
${status.count} : 1부터 시작한 반복의 현재 아이템
${status.index} : 0부터 시작한 반복의 현재 아이템
 -->
 
 <br><br>
 <!-- 마지막 아이템만 빼고 각 아이템 사이에 (,)컴마를 찍어 출력하고 싶을때 -->
 <c:forEach items="${mList}" var="movie" varStatus="state">
 	<%-- ${movie} --%> ${state.current}
 	<c:if test="${not state.last}">, </c:if> <!-- 마지막 데이터가 아니면, 표시 -->
 </c:forEach>
 
 <br><br>
 <h3>반복 실행문의 또 다른 사용 예
 <h3>
 <c:forEach var="cnt" begin="1" end="10" varStatus="status">
 	${cnt} <c:if test="${not status.last}">,</c:if>
 </c:forEach>
 </h3>
 
 <br><br>
 <table border="1" style="width:50%; text-align:center" align="left">
	<tr>
		<th>index</th><th>count</th><th>cnt</th>
	</tr>
	<c:forEach var="cnt" begin="7" end="10" varStatus="state">
			<tr>
				<td>${state.index}</td><td>${state.count}</td><td>${cnt}</td>
			</tr>
	</c:forEach>
 </table>
 </h3>
</html>