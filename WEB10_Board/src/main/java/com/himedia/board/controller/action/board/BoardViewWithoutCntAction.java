package com.himedia.board.controller.action.board;

import java.io.IOException;
import java.util.ArrayList;

import com.himedia.board.controller.action.Action;
import com.himedia.board.dao.BoardDao;
import com.himedia.board.dto.BoardDto;
import com.himedia.board.dto.ReplyDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardViewWithoutCntAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDao bdao = BoardDao.getInstance();
		
		//게시물 상세 조회
		BoardDto bdto = bdao.getBoard(num);
		
		//댓글 조회
		ArrayList<ReplyDto> list = bdao.getReply(num);
		request.setAttribute("replyList", list);
		
		request.setAttribute("board", bdto);
		request.getRequestDispatcher("board/boardView.jsp").forward(request, response);
	}
}
