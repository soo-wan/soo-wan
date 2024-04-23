package JDBC;

import java.util.ArrayList;

public class RentList_Select {

	public static void main(String[] args) {
		
		//RentDao rdao = new RenDao(); //생성자가 private으로 막힘. 싱글턴 패턴?
		RentDao rdao = RentDao.getInstance();
		ArrayList<RentDto> list = rdao.selectRent();
		
		System.out.printf("대여번호\t날짜\t\t\t회원번호\t\t성명\t\t대여가격\t할인가격\t매출액\t\t도서번호\t제목\n");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(RentDto rdto : list) {
			System.out.printf("%s\t\t%s\t\t%s\t\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n",
					rdto.getNumseq(), rdto.getRentdate(), 
					rdto.getMnum(), rdto.getName(), rdto.getRentprice(), rdto.getDiscount(),
					rdto.getAmount(), rdto.getBnum(), rdto.getSubject());
		}
	}

}
