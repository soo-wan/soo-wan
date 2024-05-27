<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String pwd =  request.getParameter("pwd");

if( id.equals("scott") && pwd.equals("1234") ){
	session.setAttribute("loginUser", id);
	session.setAttribute("name", "홍길동");
	response.sendRedirect("073_main.jsp");
}else{
response.sendRedirect("071_LoginForm.jsp");
} 
%>
