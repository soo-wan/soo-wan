<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<%@ include file="../header.jsp" %>

<section>
	<%@ include file="sub_image_menu.jsp"%>
		<article>
			<form action="shop.do?command=updateMember" method="post" name="joinForm">
				<h2>Update Member</h2>
				
				<h3>Basic Info</h3>
				<div class="field">
					<label>User ID</label>
					<input name="userid" type="text" value="${loginUser.userid}" readonly/>
				</div>
				<div class="field">
					<label>Password</label><input name="pwd" type="password"/>
				</div>
				<div class="field">
					<label>Retype Password</label><input name="pwdCheck" type="password"/>
				</div>
				<div class="field">
					<label>Name</label>
					<input name="name" type="text" value="${loginUser.name}"/>
				</div>
				<div class="field">
					<label>Phone</label>
					<input name="phone" type="text" value="${loginUser.phone}"/>
				</div>
				<div class="field">
					<label>E-Mail</label>
					<input name="email" type="text" value="${loginUser.email}"/>
				</div>
				
				<h3>Optional Info</h3>
				<div class="field">
					<label>Zip Code</label>
					<div>
					<input name="zip_num" type="text" readonly value="${loginUser.zip_num}"/>
					<input  type="button" onClick="post_zip()" value="우편번호 찾기"/>
					</div>
				</div>
				<div class="field">
					<label>Address</label>
					<input name="address1" type="text" readonly value="${loginUser.address1}"/>
				</div>
				<div class="field">
					<label>Detail Address</label>
					<input name="address2" type="text" value="${loginUser.address2}"/>
				</div>
				<div class="btn">
					<input type="button" value="회원정보수정" onClick="go_updateMember()" />
				</div>
			</form>
		</article>
	</div>
</section>
<%@ include file="../footer.jsp" %>