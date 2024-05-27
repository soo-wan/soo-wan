<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	지정된 서블릿에 데이터를 보내고 request의 attribute에 각 데이터를 담아서 92_JSP_ServletEx.jsp 파일로 전송
	각자의 형식을 자유롭게 출력해주세요.
	서블릿이름 : joinServlet   urlMapping: join.do
 -->
<form method="post" action="../join.do">
      <label for="userid"> 아이디 : </label><input type="text" name="id" ><br><br>
      <label for="userpwd"> 암&nbsp;호 : </label><input type="password" name="pwd" ><br><br>
      <label for="gender"> 성별 : </label>
         <input type="radio" name="gender" value="1"> 남자 
         <input type="radio" name="gender" value="2"> 여자 <br><br>
      <label for="content"> 간단한 가입 인사를 적어주세요^o^ </label><br>
         <textarea name="content" rows="3" cols="35"></textarea><br><br>
      <label for="item">구입항목</label><br>
         <input type="checkbox" name="item" value="1"> 신발   
         <input type="checkbox" name="item" value="2"> 가방 
         <input type="checkbox" name="item" value="3"> 벨트
         <input type="checkbox" name="item" value="4"> 모자   
      <br><br>
      <span style="float: left; margin-right: 20px">
         <label for="job">직업</label>
         <select id="job" name="job" size="1">
            <option value="">선택하세요</option>              <option value="1">학생</option>
            <option value="2">컴퓨터/인터넷</option>         <option value="3">언론</option>
         </select>   
      </span>
      <input type="submit" value="전송" >
</form>
</body>
</html>