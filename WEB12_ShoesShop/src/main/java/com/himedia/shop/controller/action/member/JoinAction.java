package com.himedia.shop.controller.action.member;

import java.io.IOException;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.MemberDao;
import com.himedia.shop.dto.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = new MemberVO();
		
		mvo.setUserid(request.getParameter("userid"));
		mvo.setPwd(request.getParameter("pwd"));
		mvo.setName(request.getParameter("name"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setZip_num(request.getParameter("zip_num"));
		mvo.setAddress1(request.getParameter("address1"));
		mvo.setAddress2(request.getParameter("address2"));
		mvo.setPhone(request.getParameter("phone"));
		
		int result = mdao.insertMember(mvo);
		HttpSession session = request.getSession();
		if(result==1) session.setAttribute("message", "회원가입이 완료되었습니다. 로그인하세요");
		else session.setAttribute("message", "회원가입 실패 관리자에게 문의하세요");
		//insert는 forward로 안한다? sendRedirect를 씀, message 넘기려면 파라미터로 넘기던가 session에 저장.
		response.sendRedirect("shop.do?command=loginForm");
	}
}
