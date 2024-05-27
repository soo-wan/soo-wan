<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script src="script/board.js"></script>
</head>
<body>
	<form name="join" class="login-form" action="board.do" method="post">
      <input type="hidden" name="command" value="join" />
        <h2>Join</h2>
        <div class="field">
        	<label>User ID</label>
        	<input style="flex:3" type="text" name="userid">
        	<input style="flex:1" type="button" value="ID Check" onClick="idcheck()">
        	<input type="hidden" name="reid">
        </div>
        <div class="field"><label>Password</label><input type="password" name="pwd"></div>
        <div class="field"><label>Retype pwd</label><input type="password" name="pwd_check"></div>
        <div class="field"><label>Name</label><input type="text" name="name"></div>
        <div class="field"><label>Email</label><input type="text" name="email"></div>
        <div class="field"><label>Phone</label><input type="text" name="phone"></div>
        <div class="login-button">
            <input type="submit" class="btn-login" value="Join"
            onClick ="return joinCheck()" />
            <input type="button" class="btn-login" value="Back" 
            onClick="location.href='board.do?command=loginForm' "/>
        </div>
    </form>
</body>
</html>