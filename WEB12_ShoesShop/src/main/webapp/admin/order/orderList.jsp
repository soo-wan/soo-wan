<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp" %>
<%@ include file="/admin/sub_menu.jsp" %>
<article>
	<form method = "post" name="frm">
	<div class="tb">
		<div class="row">
			<div class="col" style="display:flex; align-items: center;">
				주문 상품명 : &nbsp;<input type="text" name="key" value="${key}">
				&nbsp;&nbsp;&nbsp;
				<input type="button" name="btn_search" value="검색"
				onClick="go_search( 'adminOrderList' )"
				style="background-color: blueviolet; color:white; border:none; font-size: 90%;" > <!-- &nbsp;&nbsp;&nbsp; -->
				
			</div>
		</div>
		
		<div class="row">
			<div class="coltitle" style="flex:2">주문번호(처리)</div>
			<div class="coltitle" style="flex:1">주문자</div>
			<div class="coltitle" style="flex:1">상품명</div>
			<div class="coltitle" style="flex:1">수량</div>
			<div class="coltitle" style="flex:1">우편번호</div>
			<div class="coltitle" style="flex:4">주소</div>
			<!-- <div class="coltitle">전화</div> -->
			<div class="coltitle" style="flex:2">주문일</div>
		</div>
		<c:forEach items="${orderList}" var="orderVO">
			<div class="row">
				<div class="col" style="flex:2">
					${orderVO.oseq}
					<c:if test="${orderVO.result=='1'}">
						(<input type="checkbox" name="result" value="${orderVO.odseq}"> 주문완료)
					</c:if>
					<c:if test="${orderVO.result=='2'}">
						(<span style="font-weight: bold; color:red;">처리완료</span>)
					</c:if>
				</div>
				<div class="col" style="flex:1">${orderVO.mname}</div>
				<div class="col" style="flex:1">${orderVO.pname}</div>
				<div class="col" style="flex:1">${orderVO.quantity}</div>
				<div class="col" style="flex:1">${orderVO.zip_num}</div>
				<div class="col" style="flex:4">${orderVO.address1} ${orderVO.address2}</div>
				<%-- <div class="col" style="flex:2">${orderVO.phone}</div> --%>
				<div class="col" style="flex:2">
					<fmt:formatDate value="${orderVO.indate}"/>
				</div>
			</div>
		</c:forEach>
		<div class="row">
			<div class="col">
				<jsp:include page="/admin/paging/paging.jsp">
					<jsp:param value="shop.do?command=adminOrderList" name="address" />
				</jsp:include>
			</div>
		</div>
		<div class="btn">
			<input type="button" style="width:200px;" value="처리완료" onClick="go_order_save()">
		</div>
	</div>
	</form>
</article>

<%@ include file="/admin/footer.jsp" %>