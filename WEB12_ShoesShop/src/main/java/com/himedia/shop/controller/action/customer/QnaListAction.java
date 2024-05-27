package com.himedia.shop.controller.action.customer;

import java.io.IOException;
import java.util.ArrayList;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.QnaDao;
import com.himedia.shop.dto.MemberVO;
import com.himedia.shop.dto.QnaVO;
import com.himedia.shop.util.Paging;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class QnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		if(mvo == null) {
			response.sendRedirect("shop.do?command=loginForm");
		} else {
			QnaDao qdao = QnaDao.getInstance();
			//ArrayList<QnaVO> list = qdao.selectQna();
			
			//페이징
			int page = 1;
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if ( session.getAttribute("page") !=null ) {
				page = (Integer)session.getAttribute("page");
			}
			//보던 페이지가 있으면 1페이지 이동하는것이 아니라 보던 페이지로 돌아가려고 세션에 저장.
			
			Paging paging = new Paging();
			paging.setPage(page); 
			//paging.setDisplayPage(5);
			//paging.setDisplayRow(5);
			
			int count = qdao.getAllCount();
			System.out.println("레코드 갯수 : " + count);
			
			paging.setTotalCount(count); 
			
			ArrayList<QnaVO> list = qdao.selectQna(paging);
			
//			for(QnaVO qvo : list) {
//				count = qdao.getReplyCount(qvo.getQseq());
//				qvo.setQnacnt(count);
//			}
			
			request.setAttribute("paging", paging);
			//--
			request.setAttribute("qnaList", list);
			request.getRequestDispatcher("customer/qnaList.jsp").forward(request, response);
		}
	}
}
