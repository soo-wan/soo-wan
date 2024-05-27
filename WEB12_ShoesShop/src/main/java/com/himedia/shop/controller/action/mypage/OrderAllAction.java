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

public class OrderAllAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
			
			if(mvo == null) {
				response.sendRedirect("shop.do?command=loginForm");
			} else {
				ArrayList<OrderVO> finalList = new ArrayList<OrderVO>();
				OrderDao odao = OrderDao.getInstance();
				
				ArrayList<Integer> oseqList = odao.selectOseqOrderAll(mvo.getUserid()); 
				
				for ( Integer oseq : oseqList ) {
					ArrayList<OrderVO> orderListByOseq = odao.selectOrderByOseq(oseq);
					OrderVO temp = (OrderVO)orderListByOseq.get(0);
					temp.setPname(temp.getPname() + " 포함 " + orderListByOseq.size() + "건" );
					int totalprice = 0;
					for ( OrderVO ovo : orderListByOseq) {
						totalprice += ovo.getPrice2() * ovo.getQuantity();
					}
					temp.setPrice2(totalprice);
					finalList.add(temp);
				}
				request.setAttribute("finalList", finalList);
				request.setAttribute("title", "총 주문 내역");
				request.getRequestDispatcher("mypage/mypage.jsp").forward(request, response);
			}
	}
}
