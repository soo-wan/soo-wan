<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<article>
<form method="post" name="frm">
   <div class="tb">
      <div class="row">
         <div class="col" style="display:flex; align-items: center">
               회원 성명&nbsp; <input type="text" name="key" value="${key}" />&nbsp;&nbsp;&nbsp;
               <!-- <input class="btn" type="button" name="btn_search" value="검색"
                  onClick="go_search( 'adminMemberList')" />&nbsp;&nbsp;&nbsp; -->
                <input type="button" name="btn_search" value="검색"
				onClick="go_search( 'adminMemberList' )"
				style="background-color: blueviolet; color:white; border:none; font-size: 90%;" > <!-- &nbsp;&nbsp;&nbsp; -->
         </div>
      </div>
      <div class="row">
         <div class="coltitle" style="flex:1">아이디(탈퇴여부)</div>
         <div class="coltitle" style="flex:1">이름</div>
         <div class="coltitle" style="flex:4">이메일</div>
         <div class="coltitle" style="flex:1">우편번호</div>
         <div class="coltitle" style="flex:3">주소</div>
         <div class="coltitle" style="flex:1">전화</div>
         <div class="coltitle" style="flex:2">가입일</div>
      </div>   
      <c:forEach items="${memberList}" var="memberVO">
         <div class="row">
            <div class="col" style="flex:1">
               ${memberVO.userid} 
               <c:choose>
                     <c:when test='${memberVO.useyn=="Y"}'>
                       <input type="checkbox" name="useyn" readonly>
                    </c:when>
                    <c:otherwise>
                       <input type="checkbox" name="useyn" checked="checked" readonly />
                    </c:otherwise>
                </c:choose>
            </div>
            
            <div class="col" style="flex:1">${memberVO.name} </div>
            <div class="col" style="flex:4">${memberVO.email} </div>
            <div class="col" style="flex:1">${memberVO.zip_num} </div>
            <div class="col" style="flex:3">${memberVO.address1} ${orderVO.address2}</div>
            <div class="col" style="flex:1">${memberVO.phone} </div>
            <div class="col" style="flex:2"><fmt:formatDate value="${memberVO.indate}" /></div>
         </div>   
      </c:forEach>
      <div class="row">
         <div class="col">
             <jsp:include page="/admin/paging/paging.jsp" >
               <jsp:param value="shop.do?command=adminMemberList" name="address"/>
            </jsp:include>
         </div>
      </div>
   </div>
   
<form>
</article>


<%@ include file="/admin/footer.jsp"%>