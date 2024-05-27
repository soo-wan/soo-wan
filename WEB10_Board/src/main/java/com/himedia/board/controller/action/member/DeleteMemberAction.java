package com.himedia.board.controller.action.member;

import java.io.IOException;

import com.himedia.board.controller.action.Action;
import com.himedia.board.dao.MemberDao;
import com.himedia.board.dto.MemberDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto mdto = (MemberDto)session.getAttribute("loginUser");
		
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.deleteMember(mdto.getUserid());

		session.invalidate();
		
		if(result==1) {
			request.setAttribute("message", "회원정보가 정상적으로 삭제되었습니다.");
		} else {
			request.setAttribute("message", "회원탈퇴가 정상적으로 완료되지 못했습니다. 다음에 다시 시도하세요");
		}
		request.getRequestDispatcher("member/loginForm.jsp").forward(request, response);
	}
}
