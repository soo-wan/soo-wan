package com.himedia.shop.controller.action.product;

import java.io.IOException;
import java.util.ArrayList;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.ProductDao;
import com.himedia.shop.dto.ProductVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CategoryAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kind = request.getParameter("kind");
		ProductDao pdao = ProductDao.getInstance();
		ArrayList<ProductVO> list = pdao.selectKindProduct(kind);
		
		String kindList[] = {"", "Heels", "Boots", "Sandals", "Snickers", "Slipers"};
		
		request.setAttribute("kindProduct", list);
		request.setAttribute("kind", kindList[Integer.parseInt(kind)]);
		request.getRequestDispatcher("product/productKind.jsp").forward(request, response);
	}
}
