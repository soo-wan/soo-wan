package com.himedia.board.controller.action.member;

import java.io.IOException;

import com.himedia.board.controller.action.Action;
import com.himedia.board.dao.MemberDao;
import com.himedia.board.dto.MemberDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid);
		
		String url = "member/loginForm.jsp";
		if(mdto == null) {
			request.setAttribute("message", "id가 없습니다.");
		}else if(mdto.getPwd() == null) {
			request.setAttribute("message", "DB 오류. 관리자에게 문의하세요.");
		}else if(!mdto.getPwd().equals(pwd)) {
			request.setAttribute("message", "비밀번호가 틀립니다.");
		}else if(mdto.getPwd().equals(pwd)) {
			url = "board.do?command=main";
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto);
		}else {
			request.setAttribute("message", "알수없는 이유로 로그인이 안됩니다. 관리자에게 문의하세요");
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
