<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <div class="sub_img">
 	<img src="images/mypage/sub_img.jpg">
</div>

<script src="script/mypage.js"></script>
		
<div class="sub_page">
	<nav class="sub_menu">
		<div><a href="shop.do?command=cartList">cart</a></div>
		<div><a href="shop.do?command=mypage">진행중인 주문</a></div>
		<div><a href="shop.do?command=orderAll">총 주문</a></div>
		<div><a href="shop.do?command=updateMemberForm">정보 수정</a></div>
		<div><a href="#" onclick="withdrawal();">회원탈퇴</a></div>
	</nav>
