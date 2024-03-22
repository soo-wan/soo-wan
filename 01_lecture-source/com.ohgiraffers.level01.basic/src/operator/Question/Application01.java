package operator.Question;

public class Application01 {
    public static void main(String[] args) {

        int x = 2;
        int y = 5;
        char c = 'A'; // 'A'의 문자코드는 65
        System.out.println(y >= 5 || x < 0 && x > 2); //true , 앞에가 true인데 or니까 뒤에 안봐도 true --
        System.out.println(y += 10 - x++); //y = 13, x = 2  , (15-2) x는 출력후 올라감.
        System.out.println(x+=2); // x= 5 , x=3+2 --
        System.out.println( !('A' <= c && c <='Z') ); // false , true & true의 not이니 false --
        System.out.println('C'-c); // 2, 67-65 --
        System.out.println('5'-'0'); //50 , 문자라서..? ??--
        System.out.println(c+1); // 66 , 65+1
        System.out.println(++c); // B , 65+1 --
        System.out.println(c++); // 65 , 나중에 66
        System.out.println(c); // 65

        /* Application01
        int x = 2;
		int y = 5;
		char c = 'A'; // 'A'의 문자코드는 65
		System.out.println(y >= 5 || x < 0 && x > 2);
		System.out.println(y += 10 - x++);
		System.out.println(x+=2);
		System.out.println( !('A' <= c && c <='Z') );
		System.out.println('C'-c);
		System.out.println('5'-'0');
		System.out.println(c+1);
		System.out.println(++c);
		System.out.println(c++);
		System.out.println(c);

		System.out.println() 의 결과를 예측하고 이유를 설명하시오.
		*/
    }
}
