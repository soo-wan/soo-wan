<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 액션태그를 실습하기 위한 예제이므로 서블릿은 사용하지 않고 do 파일을 이용하겠습니다.  -->
<form action="102_ActionTag_do.jsp">
      아이디 : <input type="text" name="userID" ><br>
      암&nbsp;호 : <input type="password" name="userPwd" ><br>
      <input type="radio" name="loginCheck" value="user" checked="checked"> 사용자 
      <input type="radio" name="loginCheck" value="manager"> 관리자
      <br>
      <input type="submit" value="로그인" >
 </form>
</body>
</html>