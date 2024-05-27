<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--  -->
<form action="Upload.do" method="post" enctype="multipart/form-data">
	글쓴이 : <input type="text" name="name"><br>
	제 &nbsp; 목 : <input type="text" name="title"><br>
	파일 지정하기 : <input type="file" name="uploadFile"><br>
	<input type="submit" value="전송">
</form>
<!-- 파일 업로드시 지켜야할 사항 #1 : method는 반드시 post로 합니다 -->
<!-- 파일 업로드시 지켜야할 사항 #2 : enctype="multipart/form-data" 속성을 추가합니다 -->

</body>
</html>