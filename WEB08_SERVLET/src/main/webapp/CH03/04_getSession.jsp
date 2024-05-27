<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>세션에 저장된 값 하나씩 추출<br>
<%
String id = (String)session.getAttribute("id");
String pwd = (String)session.getAttribute("pwd");
Integer age = (Integer)session.getAttribute("age");
%>
id : <%=id %><br>
pwd : <%=pwd %><br>
age : <%=age %><br>

<h3>세션에 설정된 모든 값 얻어오기</h3>
<%
java.util.Enumeration<String> names = session.getAttributeNames(); //attribute의 key들 추출
while(names.hasMoreElements()){
	String name = names.nextElement().toString(); //키값 하나씩 꺼내서
	String value = session.getAttribute(name).toString(); //value 값 추출
	out.println("<h3>key : " + name+ " - value : "  + value + "</h3>"); //출력
}
%>
</h3>
</body>
</html>