package com.himedia.test2.controller.action.product;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import com.himedia.test2.controller.action.Action;
import com.himedia.test2.dao.ProductDao;
import com.himedia.test2.vo.ProductVO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

public class AddProductAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductVO pvo = new ProductVO();
		pvo.setKind(request.getParameter("kind"));
		pvo.setName(request.getParameter("name"));
		pvo.setPrice1(Integer.parseInt(request.getParameter("price1")));
		pvo.setPrice2(Integer.parseInt(request.getParameter("price2")));
		pvo.setPrice3(Integer.parseInt(request.getParameter("price3")));
		pvo.setContent(request.getParameter("content"));
		
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath("/product_images");
		
		File uploadDir = new File(uploadFilePath);
		if(!uploadDir.exists()) uploadDir.mkdir();
		
		String fileName = "";
		for(Part p : request.getParts()) {
			fileName="";
			for(String content : p.getHeader("content-disposition").split(";")) {
				if(content.trim().startsWith("filename")) 
					fileName = content.substring(content.indexOf("=")+2, content.length()-1);
			}
			String saveFilename = "";
			if(!fileName.equals("")) {
				Calendar today = Calendar.getInstance();
				long dt = today.getTimeInMillis();
				String fn1 = fileName.substring(0,fileName.indexOf("."));
				String fn2 = fileName.substring(fileName.indexOf("."));
				saveFilename = fn1 + dt + fn2;
				p.write(uploadFilePath + File.separator + saveFilename);  
				pvo.setImage(fileName);
				pvo.setSavefilename(saveFilename);
			}
		}
		
		ProductDao pdao = ProductDao.getInstance();
		pdao.insertProduct(pvo);
		request.setAttribute("filename", pvo.getSavefilename());
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}
