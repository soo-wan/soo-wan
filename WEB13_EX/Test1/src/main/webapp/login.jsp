<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link  rel="stylesheet" href="test.css">
<script src="script/member.js"></script>
</head>
<body>
<div id="wrap">
	<article>
			<form method="post" action="test.do?command=userlogin" name="login" >
					<input type="hidden" name="command" value="login" />
					<h2>LogIn</h2>
					<div class="field">
							<label>User ID</label><input name="id" type="text" />
					</div>
					<div class="field">
							<label>Password</label><input name="pass" type="password" >
					</div>
					<div class="btn">
	  				        	<input type="submit" value="LOGIN" onClick="loginCheck()"/>
	  				        	<!-- <input type="submit" class="btn-login" value="log in" onClick="loginCheck()"/> -->
					</div>
					<div style="font-size:80%; font-weight:bold">${msg} </div>
			</form>
	</article>
	
</div>

</body>
</html>
