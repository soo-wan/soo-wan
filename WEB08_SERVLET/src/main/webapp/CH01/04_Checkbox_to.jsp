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
	// String item = request.getParameter("item");
	String [] item = request.getParameterValues("item");
	String gender = request.getParameter("gender");
	if(item==null){
		out.print("<h3>선택한 항목이 없습니다.</h3>");
	}else{
		out.print("<h3>당신이 선택한 항목은 아래와 같습니다.</h3>");
	for(String t : item){
		out.print("<h3>"+t+"</h3>");
	}
}
%>
	<%-- 선택한 아이템 : <%=item %><br /> --%>
	성별 : <%=gender %>
</body>
</html>