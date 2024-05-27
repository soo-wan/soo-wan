<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<%@ include file="../header.jsp" %>

<section>
	<%@ include file="sub_image_menu.jsp"%>
		<article>
			<form name="orderFrm">
				<h2> Order List </h2>
				<c:choose>
					<c:when test="${orderList.size()==0}">
						<h3>주문내역이 없습니다.</h3>
					</c:when>
					<c:otherwise>
						<div class="tb">
							<div class="row">
								<div class="coltitle">상품명</div>
								<div class="coltitle">수 량</div>
								<div class="coltitle">가 격</div>
								<div class="coltitle">주문일</div>
								<div class="coltitle">진행상태</div>
							</div>
							<c:forEach items="${orderList}" var="orderVO">
								<div class="row">
									<div class="col">${orderVO.pname}</div>
									<div class="col">${orderVO.quantity}</div>
									<div class="col">
										<fmt:formatNumber value="${orderVO.price2}" type="currency"/>	
									</div>
									<div class="col">
										<fmt:formatDate value="${orderVO.indate}" type="date"/>
									</div>
									<div class="col">
										처리 진행 중 
										<%-- ${orderVO.result} --%>
									</div>
								</div>
							</c:forEach>
							
							<div class="row">
								<div class="col"> 총 액 </div>
								<div class="col">
									<fmt:formatNumber value="${totalprice}" type="currency"/>
								</div>
								<div class="col">
									<input type="button" value="쇼핑계속하기" onclick="location.href='shop.do?command=index'">
								</div>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</form>
		</article>
	</div>
</section>
<%@ include file="../footer.jsp" %>