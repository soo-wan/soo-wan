<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="script/product.js"></script>
<link  rel="stylesheet" href="test.css">
</head>
<body>
<div id="wrap">
	<article>
			<form method="post" action="test.do?command=addProduct" name="productWriteFrm" enctype="multipart/form-data">
					<h2>Write Product</h2>
					<div class="field" >
							<label>상품분류</label>
							<div>
								<select name="kind" style="width:200px;height:25px;font-size:105%;">
										<option value="">선택하세요</option>
										<c:forEach items="${kindList}" var="kind" varStatus="status">
								    			<option value="${status.count}">${kind}</option>
								   		</c:forEach>
								</select>
							</div>
					</div>
					<div class="field" >
							<label>상품명</label>	<input type="text" name="name"  />
					</div>
					<div class="field" >
							<label>원가</label>
							<input type="text" name="price1"  style="margin-right:20px;" onKeyup="cals();" />
							<label>판매가</label>	
							<input type="text" name="price2"  style="margin-right:20px;" onKeyup="cals();"  />
							<label>마진</label><input type="text" name="price3" readonly/>
					</div>
					<div class="field" >
							<label>상세설명</label><textarea name="content" rows="8" style="flex:4;"></textarea>
					</div>
					<div class="field" >
							<label>상품이미지</label><input type="file" name="image">
					</div>
					<div class="btn" >
							<input type="submit" value="상품등록" > 
					</div>
			</form>
	</article>
	
</div>

</body>
</html>
