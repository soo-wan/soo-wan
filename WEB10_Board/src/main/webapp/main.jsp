<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 세션 로그인유저가 없으면 로그인폼으로 이동 -->
<c:if test="${empty loginUser}">
	<jsp:forward page='board.do?command=loginForm' />
</c:if>    

<link rel="stylesheet" type="text/css" href="css/board.css">
<script src="script/board.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="main_container">
<h2>게시글 리스트</h2>
	<div class="logininfo">
		<div class="login">
			${loginUser.name}(${loginUser.userid})님이 로그인하셨습니다
			<input type="button" value="회원정보수정" 
			onClick="location.href='board.do?command=updateMemberForm' ">
			<input type="button" value="로그아웃" 
			onClick="location.href='board.do?command=logout' ">
			<input type="button" value="회원탈퇴" onClick="withDraw();">
		</div>
		<div class="writebutton">
				<input type="button" value="게시글 등록" 
				onClick="location.href='board.do?command=insertBoardForm' ">
		</div>
	</div>	
	
	<div class="board">
		<div class="title_row">
			<div class="title_col">번호</div><div class="title_col">제목</div>
			<div class="title_col">작성자</div><div class="title_col">작성일</div>
			<div class="title_col">조회수</div>
		</div>
		<c:forEach items="${boardList}" var="board">
			<div class="row">
				<div class="col">${board.num}</div>
				<div class="col">
					<a style="text-decoration: none" href="board.do?command=boardView&num=${board.num}">
						${board.title}
					</a> &nbsp;
				<c:if test="${board.replycnt>0}">
					<span style="color:red; font-weight:bold">[${board.replycnt}]</span>
				</c:if>
				
				<c:if test="${not empty board.image}">
					<span style="color:blue; font-weight:bold; font-size:90%">[img]</span>
				</c:if>
				
				</div>
				<div class="col">${board.userid}</div>
				<div class="col"><fmt:formatDate value="${board.writedate}"/></div>
				<div class="col">${board.readcount}</div>
			</div>
		</c:forEach>
	</div>
	<div class="paging">
		<!-- prev 버튼 표시 여부 -->
		<c:if test="${paging.prev}">
		
			<a href="board.do?command=main&page=${paging.beginPage-1}">◀</a>&nbsp;
		</c:if>
		
		<!-- beginPage부터 endPage까지 일렬로 페이지를 표시 -->
		<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
			<c:if test="${paging.page == index}">
				<span style="color : red">&nbsp;${index}&nbsp;</span>
			</c:if>
			<c:if test="${paging.page != index}">
				<a href="board.do?command=main&page=${index}">&nbsp;${index}&nbsp;</a>
			</c:if>
		</c:forEach>
		
		<!-- next 버튼 표시 여부 -->
		<c:if test="${paging.next}">
			<a href="board.do?command=main&page=${paging.endPage+1}">▶</a>&nbsp;
		</c:if>
	</div>
</div>
</body>
</html>