<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원의 정보 입력 폼</h2>
<form method="post" action="insertMember_do.jsp">
   <table>
   <tr><td>아이디</td><td><input type="text" name="id" size="20"></td></tr>
      <tr><td>이름</td><td><input type="text" name="name" size="20"></td></tr>
      <tr><td>비밀번호</td>   <td><input type="password" name="pwd" size="20"></td></tr>
      <tr><td>전화번호</td>   <td><input type="text" name="phone" size="11"></td></tr>
      <tr><td colspan="2">
         <input type="submit" value="전송">
         <input type="reset" value="취소">
         <input type="button" value="돌아가기" onClick="location.href='MemberMGR.jsp'">
      </td></tr>
   </table>
</form>
</body>
</html>