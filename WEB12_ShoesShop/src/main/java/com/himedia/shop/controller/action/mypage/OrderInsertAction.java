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

public class OrderInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		if(mvo == null) {
			response.sendRedirect("shop.do?command=loginForm");
		} else {
			// 1. 장바구니의 물건을 일괄 주문할때 -> 아이디로 장바구니를 검색
			CartDao cdao = CartDao.getInstance();
			ArrayList<CartVO> list1 = cdao.selectCart(mvo.getUserid());
			
			// 2. 장바구니의 선택한 물건만 주문할때 -> 전송된 cseq 들로 검색
			String[] cseqs = request.getParameterValues("cseq");
			ArrayList<CartVO> list2 = new ArrayList<CartVO>();
			for(String cseq : cseqs) {
				CartVO cvo = cdao.getCart(cseq);
				list2.add(cvo);
			}
			
			// 1. orders 테이블에 로그인 유저의 아이디로 레코드를 추가
			OrderDao odao = OrderDao.getInstance();
			odao.insertOrders(mvo.getUserid());
			
			// 2. 방금 orders 테이블에 추가된 레코드의 oseq를 조회
			int oseq = odao.looupMaxOseq(mvo.getUserid());
			
			// 3. list2에 있는 물건들과 oseq를 이용해서 order_detail 테이블에 레코드를 추가
			// 4. 주문된 cart 내역은 cart 테이블에서 삭제
			for(CartVO cvo : list2) {
				odao.insertOrderDetail(cvo, oseq);
				cdao.deleteCart(cvo.getCseq());
			}
			
			// 5. 방금 주문에 성공한 주문 번호를 갖고 주문 내역을 다시 조회해서 jsp로 이동한다.
			response.sendRedirect("shop.do?command=orderList&oseq=" + oseq);
		}
	}
}
