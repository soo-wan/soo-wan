package days02;

//static 키워드
//멤버변수, 멤버메서드 에 사용할 수 있는 키워드
//정적 변수(클래스의 변수), 정적 메서드(클래스의 메서드)를 선언할 때 사용

//프로그램 실행전부터 메모리에 자리를 확보하고 실행되기를 기다리는 변수/메서드 (객체생성과 상관 X)

class StaticA {
	int num;    //인스턴스 변수(non-static인 변수)
	static int number = 500; //스태틱 변수
	StaticA(){
		num = 100;
	}
}

//정의된 클래스는 순수한 정의 내용일뿐 실제로 존재하는 객체는 아닙니다.

//JVM은 프로그램이 시작되면 static 요소들만 따로 모아서 정리, 정의 , 메모리에 로드합니다.
//그중에서도 main 메소드는 실행의 시작으로 인식해서 먼저 실행됩니다.

public class ClassStatic {

	public static void main(String[] args) {
		
		StaticA s1 = new StaticA();
		System.out.println("인스턴스 변수 num : " + s1.num);
		//1.인스턴스 객체 생성이 되어야 그 이후에 비로서 멤버변수에 접근해서 저장하고 읽어올수가 있습니다.
		
		System.out.println("인스턴스 변수 num : " + new StaticA().num);
		
		//2. static 멤버 변수는 객체의 생성 유무와 전혀 상관없이 그 변수를 사용할 수 있습니다.
		System.out.println("static 변수 number : " + StaticA.number);
		//number 도 멤버 변수이기 때문에 앞에 소속 객체를 써줘야 하는데, static은 소속 객체가 없으므로
		//클래스 이름을 써서 사용합니다.
		//객체생성과 무관하게 생성된 변수이기 때문에 객체가 몇개가 생성되든 static 변수는 그 변수 하나만 존재합니다.
		//객체를 생성하지 않고도 사용할 수 있는 클래스의 멤버변수 입니다.
		
		
		//인스턴스 변수는 생성되는 객체마다 하나씩 생성, 존재하는 변수이고
		//스태틱 변수는 현재 프로그램 통틀어서 하나만 존재하는 변수.
		
		StaticA s2 = new StaticA();
		s2.num = 200;
		System.out.println("s1의 인스턴스 변수 num : " + s1.num);
		System.out.println("s2의 인스턴스 변수 num : " + s2.num);
		StaticA s3 = new StaticA();
		s3.num = 300;
		System.out.println("s3의 인스턴스 변수 num : " + s3.num);
		
		StaticA.number = StaticA.number + 50; //스태틱 변수값의 변경
		System.out.println("StaticA 클래스의 static 멤버변수 값 : " + StaticA.number);
		//클래스에는 속해있지만 생성되는 객체와는 별개인 변수 : static
	}
	
}
