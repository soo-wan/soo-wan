package com.himedia.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.do")
public class Forward_useServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Forward_useServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재 서블릿이 method="get"으로 호출될때 실행되는 메소드
		// jsp 페이지에 있던 request 와 response 가 매개변수(request, response)에 저장됩니다.
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(id.equals("scott") && pwd.equals("1234")) {
			request.setAttribute("name", "홍길동");
			RequestDispatcher rd = request.getRequestDispatcher("CH02/082_loginOK.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("CH02/081_Login_forward_servlet.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재 서블릿이 method="post"으로 호출될때 실행되는 메소드
		doGet(request, response);
	}

}
