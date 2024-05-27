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
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");


String job =request.getParameter("job");
String [] interests = request.getParameterValues("interest");
%>

<h1>당신이 선택한 직업 : <%=job %></h1>
<br><br><br>

<h1>당신이 선택한 관심분야 </h1>
<h1>
<%
	if(interests == null)
		out.print("선택한 항목이 없습니다.");
	else{
		for(String interest : interests){
			out.print(interest + "<br>");
		}
	}
%>
</h1>
</body>
</html>