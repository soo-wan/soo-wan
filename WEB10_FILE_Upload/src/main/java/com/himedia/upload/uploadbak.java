package com.himedia.upload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class uploadbak
 */
public class uploadbak extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadbak() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//버전 문제로 주석처리
				//request.setCharacterEncoding("UTF-8");
				//response.setCharacterEncoding("UTF-8");
				//String name = request.getParameter("name");
				//String title = request.getParameter("title");
				//file은 getParameter로 받을 수 없습니다
				//System.out.println("name : " + name);
				//System.out.println("title : " + title);
				
				//multipart/form-data로 보낸 파라미터는 기존의 request를 통해 보내지지만 request로 받을수 없다
				//이들은 request 전달받은 MultipartRequest를 통해 받을수있다.
				//전송되는 파일 또한 이를 통해 받아야함
				
				//----MultipartRequest를 사용하기위해 준비할 데이터들
				
				//1. 파일이 업로드 되어서 저장될 폴더를 지정함
				//String savePath = "upload";
				
				//2. 업로드될 파일의 용량을 제한하기 위해 용량을 int 변수에 저장합니다.
				//int uploadFileSizeLimit = 1024 * 1024 * 5; // 단위 byte -> 5MB
				// 1바이트 기준 1024byte = 1kbyte
				// 1024 kbyte = 1MB
				
				//3. 인코딩 방식을 지정하여 저장
//				String encType = "UTF-8";
				
				//4. 업로드될 서버의 실제 저장장소를 얻어서 upload 폴더를 조합하고 그 경로를 String 변수에 저장 
//				ServletContext context = getServletContext();
//				String uploadFilePath = context.getRealPath(savePath);
//				System.out.println(uploadFilePath);
//				
//				MultipartRequest multi = new MultipartRequest(
//						request, //jsp 에서 전달된 request 객체를 MultipartRequest로 전달함
//						//MultipartRequest 혼자서는 아무것도 할 수 없슴. request가 더해져야 재기능이 발휘됨
//						uploadFilePath, //서버상의 실제 저장장소
//						uploadFileSizeLimit, //최대 업로드 용량 제한
//						encType, //인코딩 방식
//						new DefaultFileRenamePolicy() //저장 장소에 업로드되는 파일이름 중복시 문제해결하는 객체
//				);
//				
//				String name = multi.getParameter("name");
//				String title = multi.getParameter("title");
//				System.out.println("name : " + name);
//				System.out.println("title : " + title);
	}

}
