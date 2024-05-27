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

public class OrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int oseq = Integer.parseInt(request.getParameter("oseq"));
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo == null) {
			response.sendRedirect("shop.do?command=loginForm");
		} else {
			OrderDao odao = OrderDao.getInstance();
			//order_view 에서 주문번호(oseq)로 주문을 검색하고 request에 담아서 orderList.jsp로 이동
			ArrayList<OrderVO> list = odao.selectOrderByOseq(oseq);
			request.setAttribute("orderList", list);
			
			int totalprice = 0;
			for(OrderVO ovo : list) // 조회된 주문의 총 결제금액 계산
				totalprice += ( ovo.getPrice2() * ovo.getQuantity());
			
			request.setAttribute("totalprice", totalprice);
			request.getRequestDispatcher("mypage/orderList.jsp").forward(request, response);
		}
	}
}
