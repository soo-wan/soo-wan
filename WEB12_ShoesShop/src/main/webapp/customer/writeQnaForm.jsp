<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<%@ include file="../header.jsp" %>

<section>
	<%@ include file="sub_image_menu.jsp"%>
		<article>
			<form action="shop.do?command=writeQna" method="post">
				<h2>Q & A Write</h2>
				<div class="field">
					<label>작성자</label>
					<input type="text" name="userid" value="${loginUser.userid}" readonly>
				</div>
				<div class="field">
					<label>제목</label>
					<input type="text" name="subject">
				</div>
				<div class="field">
					<label>질문내용</label>
					<textarea name="content" rows="10" cols="87"></textarea>
				</div>
				<div class="btn">
					<input type="submit" value="작성하기">
				</div>
			</form>
		</article>
	</div>
</section>
<%@ include file="../footer.jsp" %>