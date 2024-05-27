package com.himedia.shop.controller.action.member;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.MemberDao;
import com.himedia.shop.dto.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMember(userid);
		
		String url = "member/loginForm.jsp";
		if(mvo == null)
			request.setAttribute("message", "아이디가 없습니다");
		else if( !mvo.getPwd().equals(pwd)) 
			request.setAttribute("message", "패스워드가 틀립니다.");
		else if(mvo.getUseyn().equals("N"))
			request.setAttribute("message", "해당 계정은 휴면상태이거나 탈퇴상태입니다. 관리자에게 문의하세요");
		else if( mvo.getPwd().equals(pwd)) {
			url = "shop.do?command=index";
			HttpSession session =request.getSession();
			session.setAttribute("loginUser", mvo);
		}else 
			request.setAttribute("message", "관리자에게 문의하세요");
			
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
