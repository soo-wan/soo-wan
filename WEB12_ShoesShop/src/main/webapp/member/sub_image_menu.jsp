<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="sub_img">
		<img src="images/member/sub_img.jpg" />
</div>
<div class="sub_page"><!-- nav 와 article 의 부모 시작 -->

		<nav class="sub_menu">
				<c:choose>
					<c:when test="${empty loginUser}">
							<div><a href="">LOGIN</a></div>
							<div><a href="">JOIN</a></div>
							<div><a href="" onClick="">Find Id/Pw</a></div>
					</c:when>
					<c:otherwise>
							<div><a href="">update MEMBER</a></div>
							<div><a href="">LOGOUT</a></div>
					</c:otherwise>
				</c:choose>
		</nav>
