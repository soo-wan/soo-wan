<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>JSP 코드 : <%=request.getParameter("id") %></h3>
<h3>EL 코드 : ${param.id }</h3>
<%
	/* if(request.getParameter("id").equals("scott")){
		out.print("<h1>scott 님이 로그인 하셨습니다.</h1>");
	}
	위 코드는 request.getParameter("id")가 null인 경우 에러
	equals 메서드는 "null 값"으로 비교할때 오류를 발생시킴 */
%>
<br><br>
<h2>
<%
	//위와 같은 에러를 방지하기 위해 아래와 같은 연산을 사용 :
		if(request.getParameter("id") != null){
			if(request.getParameter("id").equals("scott")){
				out.print("<h1>scott 님이 로그인 하셨습니다.</h1>");
			}
		}else{
			out.print("<h1>id 가 null 입니다.</h1>");
		}
%>

<br><br>
<h2>
EL을 이용한 null과의 비교 <br>
'=='연산자 사용 결과 : <br> \${param.id=="hong"} -> ${param.id=="hong"}
<br> \${param.id eq "hong"} -> ${param.id eq "hong"}
</h2>
</h2>
</body>
</html>