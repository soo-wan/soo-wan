package com.himedia.shop.controller.action.admin;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminProductWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] kindList = {"Heels", "Boots", "Sandals", "Snickers", "Slipers"};
		request.setAttribute("kindList", kindList);
		request.getRequestDispatcher("admin/product/productWrite.jsp").forward(request, response);
	}
}
