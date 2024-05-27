package com.himedia.test2.controller.action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] kindList = {"Heels", "Boots", "Sandals", "Snickers", "Slipers"};
		request.setAttribute("kindList", kindList);
		request.getRequestDispatcher("writeProduct.jsp").forward(request, response);
	}
}
