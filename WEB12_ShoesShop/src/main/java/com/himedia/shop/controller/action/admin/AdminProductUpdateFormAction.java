package com.himedia.shop.controller.action.admin;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.ProductDao;
import com.himedia.shop.dto.ProductVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminProductUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		ProductDao pdao = ProductDao.getInstance();
		ProductVO pvo = pdao.getProduct(pseq);
		request.setAttribute("productVO", pvo);
		
		String kindList[] = {"Heels", "Boots", "Sandals", "Snickers", "Slipers"};
		request.setAttribute("kindList", kindList);
		
		/*
		 * int index = Integer.parseInt(pvo.getKind()); request.setAttribute("kind",
		 * kindList[index]);
		 */
		
		request.getRequestDispatcher("admin/product/productUpdate.jsp").forward(request, response);
	}
}
