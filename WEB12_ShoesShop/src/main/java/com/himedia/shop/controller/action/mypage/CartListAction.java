package com.himedia.shop.controller.action.mypage;

import java.io.IOException;
import java.util.ArrayList;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.CartDao;
import com.himedia.shop.dto.CartVO;
import com.himedia.shop.dto.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CartListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		if(mvo == null) {
			response.sendRedirect("shop.do?command=loginForm");
		} else {
			CartDao cdao = CartDao.getInstance();
			ArrayList<CartVO> list = cdao.selectCart(mvo.getUserid()); 
			
			int totalPrice = 0;
			for(CartVO cvo : list) {
				totalPrice += cvo.getPrice2() * cvo.getQuantity();
			}
			
			request.setAttribute("totalPrice", totalPrice);
			request.setAttribute("cartList", list);
			request.getRequestDispatcher("mypage/cartList.jsp").forward(request, response);
		}
	}
}
