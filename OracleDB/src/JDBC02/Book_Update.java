package JDBC02;

import java.util.Scanner;

public class Book_Update {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수정할 도서의 도서번호를 입력하세요 : ");
		int booknum = Integer.parseInt(sc.nextLine());
		
		BookDao bdao = new BookDao();
		
		//입력한 도서번호로 도서를 조회해서 대상 도서가 있는지 확인합니다.
		BookDto bdto = bdao.getBook(booknum);
		
		if(bdto == null) {
			System.out.println("입력한 도서번호의 도서가 존재하지 않습니다.\n 프로그램을 종료합니다.");
			return;
		}
		
		System.out.printf("제목 : %s \n수정할 제목을 입력하세요(수정하지 않으려면 Enter입력) : ", bdto.getSubject());
		String subject = sc.nextLine();
		if( !subject.equals("")) {
			bdto.setSubject(subject);
		}
		
		System.out.printf("출판년도 : %d \n수정할 출판년도를 입력하세요(수정하지 않으려면 Enter입력) : ", bdto.getMakeyear());
		String makeyear = sc.nextLine();
		if( !makeyear.equals("")) {
			bdto.setMakeyear(Integer.parseInt(makeyear));
		}
		
		System.out.printf("입고가격 : %d \n수정할 출판년도를 입력하세요(수정하지 않으려면 Enter입력) : ", bdto.getInprice());
		String inprice = sc.nextLine();
		if( !inprice.equals("")) {
			bdto.setInprice(Integer.parseInt(inprice));
		}
		
		System.out.printf("대여가격 : %d \n수정할 대여가격을 입력하세요(수정하지 않으려면 Enter입력) : ", bdto.getRentprice());
		String rentprice = sc.nextLine();
		if( !rentprice.equals("")) {
			bdto.setRentprice(Integer.parseInt(rentprice));
		}
		
		System.out.printf("제목 : %s \n수정할 등급을 입력하세요(수정하지 않으려면 Enter입력) : ", bdto.getGrade());
		String grade = sc.nextLine();
		if( !grade.equals("")) {
			bdto.setGrade(grade);
		}
		
		int result = bdao.updateBook(bdto);
		
		if(result ==1)System.out.println("레코드 수정 성공");
		else System.out.println("레코드 수정 실패");
		

	}
}
