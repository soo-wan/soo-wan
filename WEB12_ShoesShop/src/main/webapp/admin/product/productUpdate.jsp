<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp" %>
<%@ include file="/admin/sub_menu.jsp" %>

<article>
	<form name="productWriteFrm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pseq" value="${productVO.pseq}">
		<input type="hidden" name="oldimage" value="${productVO.image}">
		<input type="hidden" name="oldsavefilename" value="${productVO.savefilename}">
		
		<h2> Product Update Form </h2>
		<div class="field">
			<label>상품분류</label>
			<div>
				<select name="kind" style="width:200px; height:20px; font-size: 105%;">
					<option value="">선택하세요</option>
					<c:forEach items="${kindList}" var="kind" varStatus="status">
						<c:choose>
							<c:when test="${status.count==productVO.kind}">
								<option value="${status.count}" selected>${kind}</option>
							</c:when>
							<c:otherwise>
								<option value="${status.count}">${kind}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="field">
			<label>상품명</label>
			<input type="text" name="name" value="${productVO.name}">
		</div>
		<div class="field" style="display:flex;">
			<label style="flex:1;">가격</label>
			<div style="flex:6;"> 
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label>원가</label>
				<input type="text" name="price1" style="margin-right:5px; padding:5px;"  onKeyup="cals();"
				value="${productVO.price1}">
				<label>판매가</label>
				<input type="text" name="price2" style="margin-right:5px; padding:5px;" onKeyup="cals();"
				value="${productVO.price2}">
				<label>마진</label>
				<input type="text" name="price3" value="${productVO.price3}" readonly >
			</div>
		</div>
		
		<div class="field" style="display:block;">
			<label>베스트 상품</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<c:choose>
				<c:when test='${productVO.bestyn=="Y"}'>
					<input type="radio" name="bestyn" value="Y" checked="checked">사용
					<input type="radio" name="bestyn" value="N">미사용
				</c:when>
				<c:otherwise>
					<input type="radio" name="bestyn" value="Y">사용
					<input type="radio" name="bestyn" value="N" checked="checked">미사용
				</c:otherwise>
			</c:choose>
			
			<label style="margin-left:100px;">사용 유무</label>&nbsp;&nbsp;&nbsp;
			<c:choose>
				<c:when test='${productVO.useyn=="Y"}'>
					<input type="radio" name="useyn" value="Y" checked="checked">사용
					<input type="radio" name="useyn" value="N">미사용
				</c:when>
				<c:otherwise>
					<input type="radio" name="useyn" value="Y">사용
					<input type="radio" name="useyn" value="N" checked="checked">미사용
				</c:otherwise>
			</c:choose>
		</div>
		
		<div class="field">
			<label>상세설명</label>
			<textarea name="content" rows="8" style="flex:4;">${productVO.content}</textarea>
		</div>
		<div class="field">
			<label>상품이미지</label>
			<input type="file" name="image">
		</div>
		<div class="field">
			<label>기존이미지</label>
			<div>
				<img src="product_images/${productVO.savefilename}" width="200">
			</div>
		</div>
		<div class="btn">
			<input type="button" value="상품수정" onclick="go_update()" >
			<input type="button" value="목록으로" 
			onclick="location.href='shop.do?command=adminProductList'" >
		</div>
	</form>
</article>

<%@ include file="/admin/footer.jsp" %>