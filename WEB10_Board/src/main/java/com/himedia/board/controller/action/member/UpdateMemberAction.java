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

public class UpdateMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDto mdto = new MemberDto();
		mdto.setUserid(request.getParameter("userid"));
		mdto.setName(request.getParameter("name"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setEmail(request.getParameter("email"));
		
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.updateMember(mdto);
		if( result == 1 ) { //수정된 정보로 세션의 loginUser 수정 업데이트 합니다
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto);
		}
		RequestDispatcher rd = request.getRequestDispatcher("board.do?command=main");
		rd.forward(request, response);
	}
}
