package com.himedia.shop.controller.action.admin;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.QnaDao;
import com.himedia.shop.dto.QnaVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminQnaDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		QnaDao qdao = QnaDao.getInstance();
		QnaVO qvo = qdao.getQna(qseq);
		
		request.setAttribute("qnaVO", qvo);
		request.getRequestDispatcher("admin/qna/qnaView.jsp").forward(request, response);
	}
}
