package JDBC;

import java.util.Scanner;

public class RentList_Delete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RentDao rdao = RentDao.getInstance();
		
		System.out.print("삭제할 대여 기록의 번호를 입력하세요 : ");
		int numseq = Integer.parseInt(sc.nextLine());
		//기록이 있는지 확인합니다. 없으면 종료
		RentDto rdto =  rdao.getRent(numseq);
		if(rdto ==null) {
			System.out.println("입력한 번호의 대여 기록이 없습니다. 프로그램이 종료됩니다.");
			return;
		} 
		
		//삭제 처리
		int result =  rdao.deleteRent(numseq);
		if(result ==1)System.out.println("삭제 성공");
		else System.out.println("삭제 실패");
	}
}
