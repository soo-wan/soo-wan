package com.himedia.board.controller.action.member;

import java.io.IOException;

import com.himedia.board.controller.action.Action;
import com.himedia.board.dao.MemberDao;
import com.himedia.board.dto.MemberDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IdcheckAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터로 전달된 userid를 체크합니다.
		String userid = request.getParameter("userid");
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid);

		if(mdto==null) request.setAttribute("result", "-1");
		else request.setAttribute("result", "1");
		
		request.setAttribute("userid", userid);
		RequestDispatcher rd = request.getRequestDispatcher("member/idcheck.jsp");
		rd.forward(request, response);
	}
}
