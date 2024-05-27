package com.himedia.shop.controller.action.admin;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.AdminDao;
import com.himedia.shop.dto.ProductVO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

public class AdminProductUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductVO pvo = new ProductVO();
		pvo.setPseq(Integer.parseInt(request.getParameter("pseq")));
		pvo.setKind(request.getParameter("kind"));
		pvo.setName(request.getParameter("name"));
		pvo.setPrice1(Integer.parseInt(request.getParameter("price1")));
		pvo.setPrice2(Integer.parseInt(request.getParameter("price2")));
		pvo.setPrice3(Integer.parseInt(request.getParameter("price3")));
		pvo.setContent(request.getParameter("content"));
		pvo.setUseyn(request.getParameter("useyn"));
		pvo.setBestyn(request.getParameter("bestyn"));
		
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath("product_images");
		
		File uploadDir = new File(uploadFilePath);
		if(!uploadDir.exists()) uploadDir.mkdir();
		
		String fileName = "";
		String saveFilename = "";
		for(Part p : request.getParts()) {
			fileName="";
			for(String content : p.getHeader("content-disposition").split(";")) {
				if(content.trim().startsWith("filename")) 
					fileName = content.substring(content.indexOf("=")+2, content.length()-1);
					System.out.println(" fileName : " + fileName);
			}
			if(!fileName.equals("")) {
				Calendar today = Calendar.getInstance();
				long dt = today.getTimeInMillis();
				String fn1 = fileName.substring(0,fileName.indexOf("."));
				String fn2 = fileName.substring(fileName.indexOf("."));
				saveFilename = fn1 + dt + fn2;
				p.write(uploadFilePath + File.separator + saveFilename);  // 파일 저장
				pvo.setImage(fileName);
				pvo.setSavefilename(saveFilename);
			} else {
				pvo.setImage(request.getParameter("oldimage"));
				pvo.setSavefilename(request.getParameter("oldsavefilename"));
			}
		}
		
		AdminDao adao = AdminDao.getInstance();
		adao.updateProduct(pvo);
		response.sendRedirect("shop.do?command=adminProductDetail&pseq=" + pvo.getPseq());
	}
}
