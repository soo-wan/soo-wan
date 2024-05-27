package com.himedia.shop.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import com.himedia.shop.dao.ProductDao;
import com.himedia.shop.dto.ProductVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			ProductDao pdao = ProductDao.getInstance();
			ArrayList<ProductVO> blist = pdao.bestList();
			ArrayList<ProductVO> nlist = pdao.newList();
			
			request.setAttribute("newList", nlist);
			request.setAttribute("bestList", blist);
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
