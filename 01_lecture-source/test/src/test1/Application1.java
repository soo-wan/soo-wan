package test1;

public class Application1 {
    public static void main(String[] args) {
        /* 기본자료형 8가지를 선언 및 초기화 ( 0제외 아무값 ) */
        byte b = 1;
        short s = 1;
        int i = 1;
        long l = 1;
        char ch = 'a';
        double d = 1.0;
        float f = 1.0f;
        boolean isTrue = true;

        /* 정수 int의 값을 long 타입과 합하여 주세요 */
        int sum = i + (int)l;

        /* 삼항연산자를 이용하여 2.의 합계를 0보다 클때 양수입니다 0보다 작을때 음수입니다 표기 */
        System.out.println( (sum > 0) ? "양수입니다" : "음수입니다");

    }
}
