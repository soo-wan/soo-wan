<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/board.css">
<script src="script/board.js"></script>
<title>Insert title here</title>
</head>
<body>
<div id="main_container">
	<h2>게시글 등록</h2>
	<div class="board2">
		<form class="insertBoard" method="post" name="insertBoard" action="board.do" enctype="multipart/form-data">
			<input type="hidden" name="command" value="insertBoard">
			<div class=field>
				<label>작성자</label><input type="text" name="userid" value="${loginUser.userid}" readonly>
			</div>
			<div class=field>
				<label>비밀번호</label>
				<input style="flex:2" type="password" name="pass">
				<div style="flex:2; margin-left:20px;">게시물 수정 삭제시 필요합니다.</div>
			</div>
			<div class=field>
				<label>이메일</label><input type="text" name="email" value="${loginUser.email}">
			</div>
			<div class=field>
				<label>제목</label><input type="text" name="title">
			</div>
			<div class=field>
				<label>내용</label><textarea name="content" rows="10" cols="100"></textarea>
			</div>
			<div class=field>
				<label>이미지</label><input type="file" name="image">
			</div>
			<div class=field>
				<input type="submit" value="작성완료" onClick="return boardCheck()">
			</div>		
		</form>
	</div>
</div>
</body>
</html>