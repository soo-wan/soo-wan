package com.himedia.board.controller.action.board;

import java.io.IOException;
import java.util.ArrayList;

import com.himedia.board.controller.action.Action;
import com.himedia.board.dao.BoardDao;
import com.himedia.board.dto.BoardDto;
import com.himedia.board.util.Paging;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시판의 게시물을 모두 조회해서 request에 담고 main.jsp로 포워딩합니다
		BoardDao bdao = BoardDao.getInstance();
		
		Paging paging = new Paging();
		
		int page = 1;
		HttpSession session = request.getSession();
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			session.setAttribute("page", page);
		} else if ( session.getAttribute("page") !=null ) {
			page = (Integer)session.getAttribute("page");
		}
		paging.setPage(page); //결정된 page 값을 객체의 해당 멤버변수에 저장합니다.
		
		// 1. 페이지 구성요소들을 계산하기 위해 총 레코드 갯수부터 조회
		int count = bdao.getAllCount();
		System.out.println("레코드 갯수 : " + count);
		
		// 2. 조회한 레코드갯수를 Paging 객체의 totalCount에 입력(setTotalCount() 이용)
		paging.setTotalCount(count); //이때 calpaging()이 호출되서 모든 멤버변수가 계산됨.
		
		// 3. Paging 객체의 startNum(시작 레코드 번호)부터 displayRow(한 화면당 레코드 개수)만큼 조회합니다
		ArrayList<BoardDto> list = bdao.getAllBoard(paging);
		
		for(BoardDto bdto : list) {
			//bdto.getNum();으로 reply 테이블에서 댓글개수를 조회하고 결과를 bdto.setReplycnt로 저장
			count = bdao.getReplyCount(bdto.getNum());
			bdto.setReplycnt(count);
		}
		
		request.setAttribute("boardList", list);
		request.setAttribute("paging", paging);
		
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

}
