package com.himedia.shop.controller.action.mypage;

import java.io.IOException;
import java.util.ArrayList;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.OrderDao;
import com.himedia.shop.dto.MemberVO;
import com.himedia.shop.dto.OrderVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OrderDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo == null) {
			response.sendRedirect("shop.do?command=loginForm");
		} else {
			int oseq = Integer.parseInt(request.getParameter("oseq"));
			OrderDao odao = OrderDao.getInstance();
			ArrayList<OrderVO> list = odao.selectOrderByOseq(oseq);
			request.setAttribute("orderList", list);
			request.setAttribute("orderDetail", list.get(0));
			
			int totalprice = 0;
			for ( OrderVO ovo : list) {
				totalprice += ovo.getPrice2() * ovo.getQuantity();
			}
			request.setAttribute("totalprice", totalprice);
			
			request.getRequestDispatcher("mypage/orderDetail.jsp").forward(request, response);
		}
	}
}
