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
	String id_str = session.getId(); //현재 세션의 고유아이디(고유 코드가 부여되어 구성)얻음
	out.print("<h2>sessionid : " + id_str + "</h2>");
	
	long createdtime = session.getCreationTime(); //생성시간 : 밀리초
	long lasttime = session.getLastAccessedTime(); //마지막 접근 시간 : 밀리초

	//사이트에 머문 시간
	long time_used = (lasttime - createdtime) / 1000; //초단위
	
	session.setMaxInactiveInterval(3600); //세션의 수명(단위 : 초)
	int inactive = session.getMaxInactiveInterval() / 60; //현재 수명을 추출해서 분다위로 변환
	
	boolean b_new = session.isNew(); //최초 생성 상태 여부
%>
[1] 세션 ID는 [<%=id_str %>] 입니다. <br><hr>
[2] 당신이 웹 사이트에 머문 시간은 <%=time_used %> 초 입니다. <br><hr>
[3] 세션의 유효 시간은 <%=inactive %>분 입니다. <br><hr>
[4] 세션이 새로 만들어졌나요? <br>
<%
	if(b_new) out.print("예! 새로운 세션을 만들었슴돠");
	else out.print("아니오오! 새로운 세션을 만들지 않았슴돠");
%>
</body>
</html>