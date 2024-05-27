package com.himedia.board.controller.action.board;

import java.io.IOException;

import com.himedia.board.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertBoardFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("board/insertBoardForm.jsp").forward(request, response);
	}
}
