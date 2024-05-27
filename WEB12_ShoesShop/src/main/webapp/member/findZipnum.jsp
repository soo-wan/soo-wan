<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<div id="popup">
	<form method="post" name="form" action="shop.do?command=findZipnum">
		동 이름 : <input name = "dong" type="text">
			<input type="submit" value="찾기" class="submit">
	</form>
	
	<table id="zipcode" border="1">
		<tr><th width="100">우편번호</th><th>주소</th></tr>
		<c:forEach items="${addressList}" var="add">
			<tr>
				<td>
					<a href="#" onClick="addressOk('${add.zip_num}', '${add.sido}', '${add.gugun}', '${add.dong}')">
						${add.zip_num}
					</a>
				</td>
				<td>			
				<a href="#" onClick="addressOk('${add.zip_num}', '${add.sido}', '${add.gugun}', '${add.dong}')">
						${add.sido} ${add.gugun} ${add.dong}
				</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>