<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script src="script/board.js"></script>
</head>
<body>

<div id="main_container">
   <h2>게시글 수정</h2>
   <div class="board2">
      <form class="insertBoard" method="post" name="insertBoard" action="board.do" enctype="multipart/form-data">
         <div class="field">
            <label>작성자</label>
            <input type="text" name="userid" value="${board.userid}" readonly/>
         </div>
         <div class="field">
            <label>비밀번호</label>
            <input style="flex:2" type="password" name="pass" />
            <div  style="flex:2; margin-left:20px;">게시물 작성시 입력한 비밀번호 입력</div>
         </div>
         <div class="field">
            <label>이메일</label>
            <input type="text" name="email" value="${board.email}"/>
         </div>
         <div class="field">
            <label>제목</label><input type="text" name="title" value="${board.title}"/>
         </div>
         <div class="field">
            <label>내용</label>
            <textarea name="content"rows="10" cols="100">${board.content}</textarea>
         </div>
         <div class="field">
         	<label>이미지</label>
            <input type="file" name="image">
         </div>
         <div class="field">
         	<label>기존 이미지</label>
         	<c:choose>
         		<c:when test="${empty board.savefilename}">
         			<img src="images/nofile.jpg" height="80" style="text-align: left;">
         		</c:when>
         		<c:otherwise>
         			<img src="images/${board.savefilename}" height="80" style="text-align: left;">
         		</c:otherwise>
         	</c:choose>&nbsp;&nbsp;
         </div>
         <input type="hidden" name="oldimage" value="${board.image}">
         <input type="hidden" name="oldsavefilename" value="${board.savefilename}">
         <div class="field">
            <input type="submit" value="수정완료" onClick="return updateBoardCheck('${board.pass}')" />
            <input type="button" value="되돌아가기" onClick="" />
         </div>
         <input type="hidden" name="command" value="updateBoard" />
         <input type="hidden" name="num" value="${board.num}" />
      </form>
   </div>
</div>

</body>
</html>