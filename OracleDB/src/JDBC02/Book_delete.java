package JDBC02;

import java.util.Scanner;

public class Book_delete {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 도서의 도서번호를 입력하세요 : ");
		int booknum = Integer.parseInt(sc.nextLine());
		BookDao bdao = new BookDao();
		BookDto bdto = bdao.getBook(booknum);
		if(bdto == null) {
			System.out.println("입력한 도서번호의 도서가 존재하지 않습니다.\n 프로그램을 종료합니다.");
			return;
		}
		
		int result = bdao.deleteBook(booknum);
		
		if(result ==1)System.out.println("레코드 삭제 성공");
		else System.out.println("레코드 삭제 실패");

	}

}



