package com.himedia.shop.controller.action.admin;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.AdminDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminQnaReplyUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		String reply = request.getParameter("reply");
		AdminDao adao = AdminDao.getInstance();
		adao.qnaReplyUpdate(qseq,reply);
		response.sendRedirect("shop.do?command=adminQnaDetail&qseq=" + qseq);
	}
}
