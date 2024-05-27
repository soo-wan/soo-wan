package com.himedia.shop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.himedia.shop.controller.action.Action;

@MultipartConfig(
		fileSizeThreshold = 1024*1024, 
		maxFileSize=1024*1024*5,
		maxRequestSize = 1024*1024*5*5
)

public class ShoesShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShoesShopServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("command : "  + command);
		if(command==null)System.out.println("1. command 값 오류");
		
		ActionFactory af = ActionFactory.getInstance();
		Action ac = af.getAction(command);
		
		if(ac ==null)System.out.println("2. Action 조립 오류");
		else ac.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
