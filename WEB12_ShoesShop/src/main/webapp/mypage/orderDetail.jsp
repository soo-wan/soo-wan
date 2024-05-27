<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<%@ include file="../header.jsp" %>

<section>
	<%@ include file="sub_image_menu.jsp"%>
		<article>
			<form method="post" name="cartFrm">
				<h3>주문자 정보</h3>
					<div class="tb">
						<div class="row">
							<div class="coltitle">주문일자</div>
							<div class="coltitle">주문번호</div>
							<div class="coltitle">주문자성명</div>
							<div class="coltitle">주문총액</div>
						</div>
						<div class="row">
							<div class="col">
								<fmt:formatDate value="${orderDetail.indate}" type="date" />
							</div>
							<div class="col">${orderDetail.oseq}</div>
							<div class="col">${orderDetail.mname}</div>
							<div class="col">
								<fmt:formatNumber value="${totalprice}" type="currency" />
							</div>
						</div>
						<div class="row">
								<div class="col" style="flex:1">배송주소</div>
								<div class="col" style="flex:4">
									${orderDetail.zip_num}  /  ${orderDetail.address1}  /  ${orderDetail.address2}
								</div>
						</div>
					</div>
					
				<h3>주문 상품 정보</h3>
					<div class="tb">
						<div class="row">
							<div class="coltitle">상품명</div>
							<div class="coltitle">상품별 주문번호</div>
							<div class="coltitle">수량</div>
							<div class="coltitle">가격</div>
						</div>
						<c:forEach items="${orderList}" var="orderVO">
							<div class="row">
								<div class="col">${orderVO.pname}</div>
								<div class="col">${orderVO.odseq}</div>
								<div class="col">${orderVO.quantity}</div>
								<div class="col">
									<fmt:formatNumber value="${orderVO.price2 * orderVO.quantity}" type="currency" />
								</div>
							</div>
						</c:forEach>
						
						<div class="btn">
								<input type="button" value="뒤로" onclick="history.go(-1)">
								<input type="button" value="메인으로" 
								onclick="location.href='shop.do?command=index'">
						</div>
						
					</div>		
			</form>
		</article>
	</div>
</section>