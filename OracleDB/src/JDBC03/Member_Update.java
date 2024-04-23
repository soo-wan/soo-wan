package JDBC03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import JDBC02.BookDao;
import JDBC02.BookDto;

public class Member_Update {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 회원의 회원번호를 입력하세요 : ");
		int membernum = Integer.parseInt(sc.nextLine());
		
		MemberDao mdao = new MemberDao();
		MemberDto mdto = mdao.getMember(membernum);
		
		if(mdto == null) {
			System.out.println("입력한 번호의 회원이 존재하지 않습니다.\n 프로그램을 종료합니다.");
			return;
		}
		
		//String input ="";
		System.out.printf("이름 : %s \n수정할 이름을 입력하세요(수정하지 않으려면 Enter입력) : ", mdto.getName());
		String name = sc.nextLine();
		if( !name.equals("")) {
			mdto.setName(name);
		}
		
		System.out.printf("전화번호 : %s \n수정할 전화번호를 입력하세요(수정하지 않으려면 Enter입력) : ", mdto.getPhone());
		String phone = sc.nextLine();
		if( !phone.equals("")) {
			mdto.setPhone(phone);
		}
		
		System.out.printf("생년월일 : %s \n수정할 생년월일을 입력하세요(수정하지 않으려면 Enter입력) : ", mdto.getBirth());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String input = sc.nextLine(); //String 입력
		if( !input.equals("")) { //입력한 내용이 있다면
			java.util.Date d = sdf.parse(input); //java.util.Date로 변환
			java.sql.Date birth = new java.sql.Date(d.getTime()); //java.sql.Date로 변환
			mdto.setBirth(birth); //mdto에 저장
			Calendar c = Calendar.getInstance(); //나이 계산
			Calendar today = Calendar.getInstance(); //오늘 날짜
			c.setTime(d);  // 입력한 날짜
			int age = today.get(Calendar.YEAR) - c.get(Calendar.YEAR);
			mdto.setAge(age);
		}
		
		System.out.printf("성별 : %s \n수정할 성별을 입력하세요(수정하지 않으려면 Enter입력) : ", mdto.getGender());
		String gender = sc.nextLine();
		if( !gender.equals("")) {
			mdto.setGender(gender);
		}
		
		/*
		 * System.out.printf("나이 : %s \n수정할 나이를 입력하세요(수정하지 않으려면 Enter입력) : ",
		 * mdto.getAge()); String age = sc.nextLine(); if( !age.equals("")) {
		 * mdto.setAge(Integer.parseInt(age)); }
		 */		
		
		System.out.printf("사은포인트 : %d \n수정할 사은포인트를 입력하세요(수정하지 않으려면 Enter입력) : ", mdto.getBpoint());
		String bpoint = sc.nextLine();
		if( !bpoint.equals("")) {
			mdto.setBpoint(Integer.parseInt(bpoint));
		}
		
		int result = mdao.updateMember(mdto);
		
		if(result ==1)System.out.println("레코드 수정 성공");
		else System.out.println("레코드 수정 실패");
	}
}
