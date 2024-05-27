<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!-- 파라미터는 param을 붙임 -->
<c:url var="action" value="${param.address}" /> 
<div class="row">
	<div class="col" style="font-size:120%; font-weight: bold;">
		<c:if test="${paging.prev}">
			<a href="${action}&page=${paging.beginPage-1}">◀</a>
		</c:if>
		
		<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
		<c:if test="${paging.page == index}">
			<span style="color : red">${index}</span>
		</c:if>
		<c:if test="${paging.page != index}">
			<a href="${action}&page=${index}">${index}</a>
		</c:if>
		</c:forEach>
		
		<c:if test="${paging.next}">
			<a href="${action}&page=${paging.endPage+1}">▶</a>
		</c:if>
	</div>
</div>