package com.himedia.shop.controller.action.member;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			HttpSession session =request.getSession();
			session.removeAttribute("loginUser");
			request.getRequestDispatcher("member/loginForm.jsp").forward(request, response);

	}

}
