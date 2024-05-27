package com.himedia.shop.controller.action.admin;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.AdminDao;
import com.himedia.shop.dto.AdminVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminloginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		AdminDao adao = AdminDao.getInstance();
		AdminVO avo = adao.getAdmin(adminid);
		
		String url = "admin/adminLogin.jsp";
		if(avo==null)
			request.setAttribute("message", "존재하지 않는 아이디입니다.");
		else if( ! avo.getPwd().equals(pwd))
			request.setAttribute("message", "패스워드가 일치하지 않습니다.");
		else if( avo.getPwd().equals(pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("adminUser", avo);
			url = "shop.do?command=adminProductList";
		}
			
		request.getRequestDispatcher(url).forward(request, response);
	}
}
