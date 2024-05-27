package com.himedia.shop.controller.action.admin;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.AdminDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminOrderSaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] odseqs = request.getParameterValues("result");
		AdminDao adao = AdminDao.getInstance();
		for(String odseq : odseqs) {
			adao.updateOrderResult(Integer.parseInt(odseq));
		}
		request.getRequestDispatcher("shop.do?command=adminOrderList").forward(request, response);
	}
}
