<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<article>
<form method="post" name="frm">
   <div class="tb">
      <div class="row">
         <div class="col" style="display:flex; align-items: center">
               제목&nbsp; <input type="text" name="key" value="${key}" />&nbsp;&nbsp;&nbsp;
               <!-- <input class="btn" type="button" name="btn_search" value="검색"
                  onClick="go_search( 'adminMemberList')" />&nbsp;&nbsp;&nbsp; -->
                <input type="button" name="btn_search" value="검색"
				onClick="go_search( 'adminQnaList' )"
				style="background-color: blueviolet; color:white; border:none; font-size: 90%;" > <!-- &nbsp;&nbsp;&nbsp; -->
         </div>
      </div>
      <div class="row">
         <div class="coltitle" style="flex:2">번호(답변여부)</div>
         <div class="coltitle" style="flex:2">제목</div>
         <div class="coltitle" style="flex:1">작성자</div>
         <div class="coltitle" style="flex:2">작성일</div>
      </div>   
      <c:forEach items="${qnaList}" var="qnaVO">
         <div class="row">
            <div class="col" style="flex:2">
               ${qnaVO.qseq} 
               <c:choose>
                     <c:when test='${empty qnaVO.reply}'>
                       (미처리)
                    </c:when>
                    <c:otherwise>
                       (답변완료)
                    </c:otherwise>
                </c:choose>
            </div>
            
            <div class="col" style="flex:2">
            	<a href="shop.do?command=adminQnaDetail&qseq=${qnaVO.qseq}">
            		${qnaVO.subject}
            	</a> 
            </div>
            <div class="col" style="flex:1">${qnaVO.userid} </div>
            <div class="col" style="flex:2"><fmt:formatDate value="${qnaVO.indate}" /></div>
         </div>   
      </c:forEach>
      <div class="row">
         <div class="col">
             <jsp:include page="/admin/paging/paging.jsp" >
               <jsp:param value="shop.do?command=adminQnaList" name="address"/>
            </jsp:include>
         </div>
      </div>
   </div>
   
<form>
</article>


<%@ include file="/admin/footer.jsp"%>