package JDBC03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Member_Insert {

	public static void main(String[] args) throws ParseException {
		MemberDao mdao = new MemberDao();
		MemberDto mdto = new MemberDto();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		mdto.setName(sc.nextLine());
		
		System.out.print("전화번호를 입력하세요 : ");
		mdto.setPhone(sc.nextLine());
		
		System.out.print("성별을 입력하세요 (M/F) : ");
		mdto.setGender(sc.nextLine());
		
		//bpoint는 default 값이 0이므로 별도로 입력 받지 않습니다.
		
		//생년월일 입력 - simpleDateFormat과 Exception을 이용하여 입력을 받을 예정
		//String으로 입력 받아서 java.util.Date 형식으로 변환 후 java.sql.Date로 변환
		//그래야 memberlist 테이블의 birth(Date 자료형)필드에 insert가 가능합니다
		
		//SimpleDataFormat class : 날짜 데이터(java.util.Date)의 형식을 지정하여 표현해주는 클래스
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//sdf 객체에 날짜데이터 하나를 적용하면 "yyyy-MM-dd" 양식으로 날짜데이터를 설정하여 사용할 수 있습니다.
		//또한 SimpleDateFormat 클래스의 parse 메서드는 String 양식의 날짜데이터를 
		//실제 java.util.Date로 변환해 줍니다.
		
		System.out.print("생년월일을 입력하세요(YYYY-MM-DD) -> ");
		String input = sc.nextLine();
		java.util.Date d = sdf.parse(input);
		
		//java.util.Date을 java.sql.Date로 변환
		//d.getTime()을 java.sql.Date의 생성자의 전달인수로 넣습니다.
		java.sql.Date birth = new java.sql.Date(d.getTime());
		mdto.setBirth(birth);
		
		Calendar today = Calendar.getInstance(); //오늘 날짜
		Calendar c = Calendar.getInstance();
		c.setTime(d);  // java.util.Date -> Calendar 변환
		int age = today.get(Calendar.YEAR) - c.get(Calendar.YEAR);
		mdto.setAge(age);
		
		int result = mdao.insertMember(mdto);
		if(result==1) System.out.println("레코드 추가 성공");
		else System.out.println("레코드 추가 실패");
	}

}
