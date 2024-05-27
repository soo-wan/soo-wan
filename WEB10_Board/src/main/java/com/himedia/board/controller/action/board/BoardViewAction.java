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

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDao bdao = BoardDao.getInstance();
		
		//조회수 증가
		bdao.plusReadCount(num);
		//게시물 상세 조회
		BoardDto bdto = bdao.getBoard(num);
		request.setAttribute("board", bdto);
		
		ArrayList<ReplyDto> list = bdao.getReply(num);
		request.setAttribute("replyList", list);
		
		request.getRequestDispatcher("board/boardView.jsp").forward(request, response);
	}
}
