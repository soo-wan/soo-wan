<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp" %>

<!-- 경로가 '/'로 시작하면 가장 상위 폴더로부터 표시되는 절대 경로로 인식된다. 최상위폴더는 webapp -->
<!-- 아래와 같이 상대경로로 표시할수도 있다. -->
<%--<%@ include file="../sub_menu.jsp"%> --%>
<%@ include file="/admin/sub_menu.jsp" %>
<article>
	<form method = "post" name="frm">
	<div class="tb">
		<div class="row">
			<div class="col" style="display:flex; align-items : center;">
				상품명 : &nbsp;<input type="text" name="key" value="${key}">
				&nbsp;&nbsp;&nbsp;
				<div>
				<input class="btn" type="button" name="btn_search" value="검색"
				onClick="go_search( 'adminProductList' )">				
				</div>
				&nbsp;&nbsp;&nbsp;
				<input type="button" 
				style="margin-left: auto; background-color: blueviolet; color:white; border:none; font-size: 90%;" 
				value="상품등록" onclick="go_wrt();">	
			</div>
		</div>
		<div class="row">
			<div class="coltitle">번호</div>
			<div class="coltitle">상품명</div>
			<div class="coltitle">원가</div>
			<div class="coltitle">판매가</div>
			<div class="coltitle">등록일</div>
			<div class="coltitle">사용유무</div>
		</div>
		<c:forEach items="${productList}" var="productVO">
			<div class="row">
				<div class="col">${productVO.pseq}</div>
				<div class="col">
					<a href="#" onClick="go_detail( '${productVO.pseq}' )">
						${productVO.name}
					</a>	
				</div>
				<div class="col"><fmt:formatNumber value="${productVO.price1}"/></div>
				<div class="col"><fmt:formatNumber value="${productVO.price2}"/></div>
				<div class="col"><fmt:formatDate value="${productVO.indate}"/></div>
				<div class="col">
					<c:choose>
						<c:when test="${productVO.useyn=='N'}">미사용</c:when>
						<c:otherwise>사용</c:otherwise>
					</c:choose>
				</div>
			</div>
		</c:forEach>
		<jsp:include page="/admin/paging/paging.jsp">
			<jsp:param value="shop.do?command=adminProductList" name="address" />
		</jsp:include>
	</div>
	</form>
</article>

<%@ include file="/admin/footer.jsp" %>