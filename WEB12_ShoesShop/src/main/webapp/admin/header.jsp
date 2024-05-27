<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="admin/css/admin.css">
<script src="admin/script/admin.js"></script>
</head>
<body>

<div id="wrap">
	<header>
		<div id="logo">
			<img style="width:800px" src="admin/images/bar_01.gif">
			<img src="admin/images/text.gif">
			<input class="btn" type="button" value="logout" style="float:right;"
			onClick = "location.href='shop.do?command=adminLogout'">
		</div>
	</header>
