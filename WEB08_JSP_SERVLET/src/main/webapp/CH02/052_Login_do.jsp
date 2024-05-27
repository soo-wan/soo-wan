<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.net.URLEncoder" %>
<%
	// JSP 문법에 의한 로그인 체크 동작만 필요한 페이지이므로 별도의 HTML 태그는 사용하지 않습니다.
	// 전달된 아이디 비번의 유효성을 점검한 뒤 로그인 성공페이지로 이동하거나, 로그인페이지로 되돌아갑니다.
	
	// 전달된 아이디 비번을 변수에 저장합니다.
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	// 실제로는 데이터베이스에 저장된 회원정보와 전송된 아이디 비번으로 비교해서 로그인 처리하지만
	// 지금은 그냥 특정 아이디와 비번으로 비교합니다
	if(id.equals("scott")&& pwd.equals("1234")){
		// jsp 문법으로 페이지 이동은 response.sendRedirect();
		response.sendRedirect("053_LoginOK.jsp?id=" + id + "&name=" + URLEncoder.encode("홍길동","UTF-8"));
	}else{
		//아이디 비번이 맞지 않는 경우
		response.sendRedirect("051_Login.jsp");
	}
%>