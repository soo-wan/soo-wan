<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.setAttribute("s_name1", "저는 세션에 저장된 첫번째값이에요. ^o^");
	session.setAttribute("s_name2", "저는 세션에 저장된 두번째값이에요. ^o^");
	session.setAttribute("s_name3", "저는 세션에 저장된 세번째값이에요. ^o^");
	
	out.print("<h3> >> 세션값을 삭제하기 전 << </h3>");
	String value = (String)session.getAttribute("s_name1");
	out.println("<h3>s_name1 : " + value + "</h3>");
	value = (String)session.getAttribute("s_name2");
	out.println("<h3>s_name2 : " + value + "</h3>");
	value = (String)session.getAttribute("s_name3");
	out.println("<h3>s_name3 : " + value + "</h3>");
	
	session.removeAttribute("s_name2");
	out.print("<h3> >> 세션값을 한개를 삭제한 경우 << </h3>");
	value = (String)session.getAttribute("s_name1");
	out.println("<h3>s_name1 : " + value + "</h3>");
	value = (String)session.getAttribute("s_name2");
	out.println("<h3>s_name2 : " + value + "</h3>");
	value = (String)session.getAttribute("s_name3");
	out.println("<h3>s_name3 : " + value + "</h3>");
	
	session.invalidate();
	out.print("<h3> >> 세션값을 모두 삭제한 경우 << </h3>");
	out.print("세션이 모두 삭제 되었습니다");
%>
</body>
</html>