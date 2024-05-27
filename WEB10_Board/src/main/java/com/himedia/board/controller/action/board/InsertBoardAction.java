package com.himedia.board.controller.action.board;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import com.himedia.board.controller.action.Action;
import com.himedia.board.dao.BoardDao;
import com.himedia.board.dto.BoardDto;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

public class InsertBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao bdao = BoardDao.getInstance();
		BoardDto bdto = new BoardDto();
		
		bdto.setUserid(request.getParameter("userid"));
		bdto.setPass(request.getParameter("pass"));
		bdto.setTitle(request.getParameter("title"));
		bdto.setEmail(request.getParameter("email"));
		bdto.setContent(request.getParameter("content"));
		
		//String uploadFilePath = getServletContext().getRealPath("upload");
		// 저장 경로 설정
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath("images");
		
		// 저장 경로 생성
		File uploadDir = new File(uploadFilePath);
		if(!uploadDir.exists()) uploadDir.mkdir();
		
		String fileName = "";
		for(Part p : request.getParts()) {
				//전송된 파라미터들중 filename 이라는 글자가 포함된 헤더를 찾고, 있으면 이름 추출
				fileName="";
				for(String content : p.getHeader("content-disposition").split(";")) {
					if(content.trim().startsWith("filename")) 
						fileName = content.substring(content.indexOf("=")+2, content.length()-1);
				}
				
				//추출된 이름이 있다면
				String saveFilename = "";
				if(!fileName.equals("")) {
					Calendar today = Calendar.getInstance();
					long dt = today.getTimeInMillis();
					String fn1 = fileName.substring(0,fileName.indexOf("."));
					String fn2 = fileName.substring(fileName.indexOf("."));
					saveFilename = fn1 + dt + fn2;
					p.write(uploadFilePath + File.separator + saveFilename);  // 파일 저장
					bdto.setImage(fileName);
					bdto.setSavefilename(saveFilename);
				}
		}
		bdao.insertBoard(bdto);
		
		response.sendRedirect("board.do?command=main");
	}
}
