package com.himedia.upload;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(
	fileSizeThreshold = 1024*1024, 
	maxFileSize=1024*1024*5,
	maxRequestSize = 1024*1024*5*5
)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		//ServletContext context = getServletContext();
		//String uploadFilePath = context.getRealPath("upload");
		String uploadFilePath = getServletContext().getRealPath("upload");
		System.out.println(uploadFilePath);
		
		// File 객체에 경로를 설정하고, 체크해서 없으면 해당 경로를 생성합니다.
		File uploadDir = new File(uploadFilePath);
		if(!uploadDir.exists()) uploadDir.mkdir();
		
		String fileName = "";
		
		for( Part part : request.getParts()) {
			//part 마다 header 있음
			System.out.println(part.getHeader("content-disposition"));
			fileName = getFileName(part);
			if(fileName != null && !"".equals(fileName)) {
				
				Calendar today = Calendar.getInstance();
				long dt = today.getTimeInMillis();
				
				String fn1 = fileName.substring(0, fileName.indexOf("."));
				String fn2 = fileName.substring(fileName.indexOf("."));
				String saveFilename = fn1 + dt + fn2;
				
				part.write(uploadFilePath + File.separator + saveFilename); //파일 저장
				System.out.println("파일명 : " + fileName + "저장완료!!!");
				request.setAttribute("saveFilename", saveFilename);
			}
		}
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		System.out.println("name : " + name + ", title : " + title);
		
		request.setAttribute("filename", fileName);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	private String getFileName(Part part) {
		// 각 헤더들 ';'으로 구분해서 반복 실행
		for(String content : part.getHeader("content-disposition").split(";")) {
			// 구분한 헤더 String들중 filename으로 시작하는 String에 대해 
			if(content.trim().startsWith("filename")) {
				//=부터 두글자 뒤부터 마지막에서 두번째글자까지 추출해서 리턴
				return content.substring(content.indexOf("=")+2, content.length()-1);
			}
		}
		return null; //filename이 없는 경우(폼필드 데이터인 경우) :
	}
}
