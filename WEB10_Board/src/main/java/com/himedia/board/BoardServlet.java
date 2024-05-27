package com.himedia.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.himedia.board.controller.action.Action;
import com.himedia.board.controller.action.member.JoinFormAction;
import com.himedia.board.controller.action.member.LoginAction;
import com.himedia.board.controller.action.member.LoginFormAction;

@MultipartConfig(
		fileSizeThreshold = 1024*1024, 
		maxFileSize=1024*1024*5,
		maxRequestSize = 1024*1024*5*5
)

public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String command = request.getParameter("command");
		if(command == null) System.out.println("1.command 전달 오류" + command);
		else System.out.println("command 값 : " + command);
		
		Action ac = null;
		ActionFactory af = ActionFactory.getInstance();
		ac = af.getAction(command);
		if(ac==null) System.out.println("2.Action 전달 오류");
		else ac.execute(request, response);
		
		//LoginFormAction lfa = new LoginFormAction();
		//lfa.execute(request, response);
		//ac.execute(request, response);
//		if(command.equals("loginForm")) {
//			//member/loginForm.jsp로 포워딩 하는 코드
//			ac = new LoginFormAction();
//		}
//		else if(command.equals("login")) {
//			ac = new LoginAction();	
//		}
//		else if(command.equals("joinForm")) {
//			ac = new JoinFormAction();
//		}
//		else if(command.equals("join")) {
//			
//		}
		
//		ac.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
