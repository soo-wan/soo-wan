<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<section>
	<%@ include file="sub_image_menu.jsp"%>
			<article>
					<form method="post" action="shop.do?command=join" name="joinForm">
							<h2>Join Us</h2>
							<h3>Basic Info</h3>
							<div class="field">
								<label>User ID</label>
								<div>
									<input name="userid" type="text" size="12"/>
									<input type="hidden" name="reid"/>
									<input value="중복 체크" type="button" class="dup" onClick="idcheck()"/>
								</div>
							</div>
							<div class="field">
								<label>Password</label><input name="pwd" type="password"/>
							</div>
							<div class="field">
								<label>Retype Password</label><input name="pwdCheck" type="password"/>
							</div>
							<div class="field">
								<label>Name</label><input name="name" type="text"/>
							</div>
							<div class="field">
								<label>Phone</label><input name="phone" type="text"/>
							</div>
							<div class="field">
								<label>E-Mail</label><input name="email" type="text"/>
							</div>
							
							<h3>Optional Info</h3>
							<div class="field">
								<label>Zip Code</label>
								<div>
								<input name="zip_num" type="text" readonly/>
								<input  type="button" onClick="post_zip()" value="우편번호 찾기"/>
								</div>
							</div>
							<div class="field">
								<label>Address</label><input name="address1" type="text" readonly/>
							</div>
							<div class="field">
								<label>Detail Address</label><input name="address2" type="text"/>
							</div>
							<div class="btn">
								<input type="button" value="회원가입" onClick="go_save()" />
								<input type="button" value="메인으로" onClick="location.href='shop.do?command=index'" />
							</div>
					</form>
			</article>
		</div> 
</section>

<%@ include file="../footer.jsp" %>