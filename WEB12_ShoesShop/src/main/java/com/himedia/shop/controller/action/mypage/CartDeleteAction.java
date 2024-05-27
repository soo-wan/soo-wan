package com.himedia.shop.controller.action.mypage;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.CartDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CartDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] cseqs = request.getParameterValues("cseq");
		CartDao cdao = CartDao.getInstance();
		
		for(String cseq : cseqs) {
			cdao.deleteCart(Integer.parseInt(cseq));
		}
		
		response.sendRedirect("shop.do?command=cartList");
	}
}
