<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<%@ include file="../header.jsp" %>

<section>
	<%@ include file="sub_image_menu.jsp"%>
		<article>
			<form method="post" name="cartFrm">
				<h2>Cart List</h2>
				<c:choose>
					<c:when test="${cartList.size()==0}">
						<h3>장바구니가 비었습니다.</h3>
					</c:when>
					
					<c:otherwise>
					
						<div class="tb">
							<div class="row">
								<div class="coltitle">상품명</div>
								<div class="coltitle">수 량</div>
								<div class="coltitle">가 격</div>
								<div class="coltitle">주문일</div>
								<div class="coltitle">삭 제</div>
							</div>
							<c:forEach items="${cartList}" var="cartVO">
								<div class="row">
									<div class="col">${cartVO.pname}</div>
									<div class="col">${cartVO.quantity}</div>
									<div class="col">${cartVO.price2}</div>
									<div class="col">
										<fmt:formatDate value="${cartVO.indate}" type="date" />
									</div>
									<div class="col">
										<input type="checkbox" name="cseq" value="${cartVO.cseq}" />
									</div>
								</div>
							</c:forEach>
							<div class="row">
								<div class="col"> 총 액 </div>
								<div class="col">
									<fmt:formatNumber value="${totalPrice}" type="currency"/>
								</div>
								<div class="col">
									<a href="#" onClick="go_cart_delete();">삭제하기</a>
								</div>
							</div>
						</div>
						
					</c:otherwise>
				</c:choose>
				<div class="btn">
					<input type="button" value="쇼핑 계속하기" onclick="location.href='shop.do?command=index'">
					<c:if test="${cartList.size() !=0}">
						<input type="button" value="주문하기" onclick="go_order_insert()">
					</c:if>
				</div>
			</form>
		</article>
	</div>
</section>
<%@ include file="../footer.jsp" %>