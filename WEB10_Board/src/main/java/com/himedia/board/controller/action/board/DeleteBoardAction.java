package com.himedia.board.controller.action.board;

import java.io.IOException;

import com.himedia.board.controller.action.Action;
import com.himedia.board.dao.BoardDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDao bdao = BoardDao.getInstance();
		bdao.deleteBoard(num);
		
		//request.setAttribute("delete", "OK");
		//request.getRequestDispatcher("board.do?command=main").forward(request, response);
		request.getRequestDispatcher("board/deleteOK.jsp").forward(request, response);
	}
}
