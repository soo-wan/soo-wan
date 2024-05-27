package com.himedia.shop.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.AdminDao;
import com.himedia.shop.dto.AdminVO;
import com.himedia.shop.dto.ProductVO;
import com.himedia.shop.util.Paging;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminProductListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("adminUser");
		if( avo == null ) {
			response.sendRedirect("shop.do?command=admin");
		} else {
			int page = 1;
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if ( session.getAttribute("page") !=null ) {
				page = (Integer)session.getAttribute("page");
			} else {
				session.removeAttribute("page");
			}
			
			String key ="";
			if(request.getParameter("key")!=null) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			} else if ( session.getAttribute("key") != null ) {
				key = (String)session.getAttribute("key");
			} else {
				session.removeAttribute("key");
			}
			
			Paging paging = new Paging();
			paging.setPage(page); 
			
			AdminDao adao = AdminDao.getInstance();
			int count = adao.getAllCount("product", "name", key);
			paging.setTotalCount(count);
			
			ArrayList<ProductVO> productList = adao.adminProductList(paging, key);
			
			request.setAttribute("productList", productList);
			request.setAttribute("paging", paging);
			request.getRequestDispatcher("admin/product/productList.jsp").forward(request, response);
		}
	}
}
