<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<%@ include file="../header.jsp" %>

<section>
		<div class="sub_img">
			<img src="images/product/sub_img.jpg">
		</div>
		<div class="sub_page">
			<article style="flex-direction: column">
				<h2>${kind}</h2>
				<div class="kindproducts">
					<c:forEach items="${kindProduct}" var="productVO">
						<div class="kinditem" 
						onClick="location.href='shop.do?command=productDetail&pseq=${productVO.pseq}'">
							<img src="product_images/${productVO.savefilename}">
							<div>${productVO.name}</div>
							<div>${productVO.price2}</div>
						</div>
					</c:forEach>
				</div>
			</article>
		</div>
</section>
<%@ include file="../footer.jsp" %>