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
<form name="update" class="login-form" action="board.do" method="post">
      <input type="hidden" name="command" value="updateMember" />
        <h2>Update Member</h2>
        <div class="field">
        	<label>User ID</label>
        	<!-- flex 비율 유지하려고 이렇게 readonly로 -->
        	<input type="text" name="userid" value="${loginUser.userid}" readonly>
        	<%-- <input type="hidden" name="userid" value="${loginUser.userid}"> --%>
        </div>
        <div class="field"><label>Password</label><input type="password" name="pwd"></div>
        <div class="field"><label>Retype pwd</label><input type="password" name="pwd_check"></div>
        <div class="field"><label>Name</label><input type="text" name="name" value="${loginUser.name}"></div>
        <div class="field"><label>Email</label><input type="text" name="email" value="${loginUser.email}"></div>
        <div class="field"><label>Phone</label><input type="text" name="phone" value="${loginUser.phone}"></div>
        <div class="login-button">
            <input type="submit" class="btn-login" value="Update"
            onClick ="return updateCheck()" />
            <input type="button" class="btn-login" value="Back" 
            onClick="location.href='board.do?command=main' "/>
        </div>
</form>
</body>
</html>