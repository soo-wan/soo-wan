package com.himedia.test1.controller.action.member;

import java.io.IOException;

import com.himedia.test1.controller.action.Action;
import com.himedia.test1.dao.MemberDao;
import com.himedia.test1.dto.MemberDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserloginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("id");
		String pwd = request.getParameter("pass");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid);
		
		String url = "/login.jsp";
		if(mdto == null) {
			request.setAttribute("msg", "id가 없습니다.");
		}else if(mdto.getPwd() == null) {
			request.setAttribute("msg", "DB 오류. 관리자에게 문의하세요.");
		}else if(!mdto.getPwd().equals(pwd)) {
			request.setAttribute("msg", "비밀번호가 틀립니다.");
		}else if(mdto.getPwd().equals(pwd)) {
			url = "test.do?command=main";
			HttpSession session = request.getSession();
			session.setAttribute("lUser", mdto);
		}else {
			request.setAttribute("msg", "알수없는 이유로 로그인이 안됩니다. 관리자에게 문의하세요");
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
