package com.himedia.test2;

import java.io.IOException;

import com.himedia.test2.controller.ActionFactory;
import com.himedia.test2.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@MultipartConfig(
		fileSizeThreshold = 1024*1024, 
		maxFileSize=1024*1024*5,
		maxRequestSize = 1024*1024*5*5
)

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");	
		
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		if(command==null) System.out.println("1. command 값 오류");
		
		ActionFactory af = ActionFactory.getInstance();
		Action ac = af.getAction(command);
		
		if( ac == null ) System.out.println("2. Action 조립 오류");
		else ac.execute(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
