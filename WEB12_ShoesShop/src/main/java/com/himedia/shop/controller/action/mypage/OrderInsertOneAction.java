package com.himedia.shop.controller.action.mypage;

import java.io.IOException;
import java.util.ArrayList;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.CartDao;
import com.himedia.shop.dao.OrderDao;
import com.himedia.shop.dto.CartVO;
import com.himedia.shop.dto.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OrderInsertOneAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pseq = Integer.parseInt(request.getParameter("pseq")); //상품번호
		int quantity = Integer.parseInt(request.getParameter("quantity")); //수량
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		if(mvo == null) {
			response.sendRedirect("shop.do?command=loginForm");
		} else {
			OrderDao odao = OrderDao.getInstance();
			odao.insertOrders(mvo.getUserid());
			
			int oseq = odao.looupMaxOseq(mvo.getUserid());
			
			odao.insertOrderDetail(oseq, pseq, quantity);
			
			response.sendRedirect("shop.do?command=orderList&oseq=" + oseq);
		}
	}
}
