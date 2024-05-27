package com.himedia.shop.controller.action.mypage;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.CartDao;
import com.himedia.shop.dto.CartVO;
import com.himedia.shop.dto.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CartInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo == null) {
			response.sendRedirect("shop.do?command=loginForm");
		} else {
			CartDao cdao = CartDao.getInstance();
			CartVO cvo = new CartVO();
			
			cvo.setUserid(mvo.getUserid());
			cvo.setPseq(pseq);
			cvo.setQuantity(quantity);
			
			cdao.insertCart(cvo);
			response.sendRedirect("shop.do?command=cartList");
		} 
	}
}
