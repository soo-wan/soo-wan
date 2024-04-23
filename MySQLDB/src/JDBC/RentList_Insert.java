package JDBC;

import java.util.Scanner;

public class RentList_Insert {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RentDao rdao = RentDao.getInstance();

		String membernum;
		while(true) {
			System.out.print("대여할 회원의 회원 번호를 입력하세요 : ");
			membernum = sc.nextLine();
			int result = rdao.memberOk(membernum); // 입력한 멤버번호가 존재하면 1, 없으면 0을 리턴
			if(result ==0) {
				System.out.println("해당 회원이 없습니다. 다시 입력하세요.");
				continue;
			} else {
				break;
			}
		}
		
		String booknum;
		while(true) {
			System.out.print("대여할 도서의 도서 번호를 입력하세요 : ");
			booknum = sc.nextLine();
			int result = rdao.bookOk(booknum); // 입력한 멤버번호가 존재하면 1, 없으면 0을 리턴
			if(result ==0) {
				System.out.println("해당 도서가 없습니다. 다시 입력하세요.");
				continue;
			} else {
				break;
			}
		}
		
		System.out.println("입력된 도서 번호 : " + booknum + "\n");
		
		System.out.print("할인금액을 입력하세요 : ");
		int discount = Integer.parseInt(sc.nextLine());
		
		RentDto rdto = new RentDto();
		rdto.setMnum(Integer.parseInt(membernum));
		rdto.setBnum(Integer.parseInt(booknum));
		rdto.setDiscount(discount);
		
		int res = rdao.insertRent(rdto);
		if(res ==1)System.out.println("추가 성공");
		else System.out.println("추가 실패");
	}
}
