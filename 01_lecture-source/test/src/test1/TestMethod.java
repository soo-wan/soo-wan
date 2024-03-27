package test1;

import java.util.Scanner;

public class TestMethod {
    /* 인자값을 전달받아 사칙연산과 나머지 계산을 하는 매개변수를 전달받는 메소드 생성 */
    public void calculator(int num1, int num2){
        System.out.println("사칙연산 더하기 "+num1 +"+" +num2 + "는 " +(num1 + num2) +"입니다."); //+=으로 왜하지
        System.out.println("사칙연산 빼기 "+num1 +"-" +num2 + "는 " +(num1 - num2) +"입니다.");
        System.out.println("사칙연산 곱하기 "+num1 +"*" +num2 + "는 " +(num1 * num2) +"입니다.");
        System.out.println("사칙연산 나누기 "+num1 +"/" +num2 + "는 " +(num1 / num2) +"입니다.");
        System.out.println("사칙연산 나머지 "+num1 +"%" +num2 + "는 " +(num1 % num2) +"입니다.");
    }

    public double circleArea(){
        final double pie = 3.14;
        Scanner sc = new Scanner(System.in);
        System.out.print("반지름 값을 입력해주세요 : ");
        double radius = sc.nextDouble();
        double result = (radius*radius*pie);
        return result;
    }

    //1~10 난수
    public static String testRandom(){
        int randomNumber = (int)(Math.random() * 10) + 1 ;
        String str = "생성된 난수는 " + randomNumber + "입니다.";
        return str;
    }
}
