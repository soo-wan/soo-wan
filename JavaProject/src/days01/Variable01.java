package days01;

class Scores{
	int kor;
	int mat;
	int eng;
	int tot;
	double ave;
}
//클래스(Class)
//프로그램으로 처리하고자 하는 대상의 요소들을 자료화하여 하나의 자료형으로 정의한 사용자 정의 자료형
//쉽게 말해 필요에 의해 기본자료형(int, double, char 등)외에 그들을 그룹화하여 새롭게 정의한 자료형입니다.
//한개 이상의 자료, 하나 이상의 자료형을 저장할 수 있는 복합 자료형

//클래스는 프로그램 단위로도 사용됩니다
//클래스 = 자바의 프로그램 단위
//하나의 파일안에 여러개의 클래스를 정의하여 사용이 가능합니다.
//다만 여러개의 클래스중 하나는 파일이름과 반드시 같아야하고, pulbic 이어야 하며,
//자체 실행 여부에 따라 public void main(){}를 포함하고 있어야 합니다.
public class Variable01 {

	public static void main(String[] args) {
		//변수 //배열
		
		Scores std1 = new Scores(); //std1 : 참조변수   ,new Scores() : 인스턴스
		//new Scores()에 의해서 Heap 영역에 필요한 만큼 메모리를 확보하고 그 주소를 참조변수 std1에 전달
		
		//String str = "Korea";
		String str = new String("Korea"); //String은 클래스, 이렇게도 사용 가능
		
//		int [] kor = new int[5];
//		int [] eng = new int[5];
//		int [] mat = new int[5];
//		int [] tot = new int[5];
//		double[] ave = new double[5];
		
		std1.kor = 95;
		std1.eng = 85;
		std1.mat = 75;
		
		std1.tot = std1.kor + std1.eng + std1.mat;
		std1.ave = std1.tot / 3.0;
		
		System.out.println("\t\t ###성적표###");
		System.out.println("----------------------------------------------------------------");
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println("----------------------------------------------------------------");
		
		System.out.printf("%d\t%d\t", std1.kor, std1.eng);
		System.out.printf("%d\t%d\t", std1.mat, std1.tot);
		System.out.printf("%.1f\n", std1.ave);
		
		//같은 자료형의 다른 객체 생성
		Scores std2 = new Scores();
		
		//객체 배열 생성
		Scores[] std = new Scores[3];
		//위 문장은 참조변수 배열을 생성한거지, Scores 객체가 만들어진게 아닙니다
		
		//각각의 참조변수에 새로운 인스턴스를 할당해야 활용이 가능합니다
		std[0] = new Scores();
		std[1] = new Scores();
		std[2] = new Scores();
		
		std[0].kor = 100;
	}

}
