package com.ohgiraffers.section05.logical;

public class Application2 {
    public static void main(String[] args) {
        /* 수업 목표. 논리 연산자의 우선순위에 대해 이해하고 이를 활용할 수 있다. */
        /* 논리 연산자의 우선순위와 활용
        * 논리 and 연산자와 논리 or 연산자의 우선순위
        * && : 11순위
        * || : 12순위
        * 논리 and 연산자 우선순위가 논리 or 우선순위보다 높다.*/

        /* 1. 1부터 100 사이의 값인지 확인 */
        /* 1<= 변수 <= 100 이렇게는 사용 못함 ---> 변수 >=1 && 변수 <=100 이렇게 사용해야한다. */
        int num1 = 55;
        System.out.println("1부터 100 사이인지 확인 : " + (num1 >= 1 && num1 <= 100));

        int num2 = 166;
        System.out.println("1부터 100 사이인지 확인 : " + (num2 >= 1 && num2 <= 100));

        /* 2. 영어의 대문자인지 확인 */
        /* 영어 대문자냐?--> 문자변수 >= 'A' && 문자변수 <='Z' */
        char ch = 'G';
        System.out.println("영어의 대문자인지 확인 : " +(ch >= 'A' && ch <= 'Z'));

        char ch1 = 'g';
        System.out.println("영어의 대문자인지 확인 : " +(ch1 >= 'A' && ch1 <= 'Z'));

        /* 3. 대소문자와 상관없이 영문자 y인지 확인 */
        /* 문자 변수 == 'y' || 문자변수 =='Y' */
        char ch2 = 'y';
        System.out.println("영문자 y인지 확인 : " +(ch2 == 'Y' || ch2 == 'y'));

        char ch3 = 'Y';
        System.out.println("영문자 y인지 확인 : " +(ch3 == 'Y' || ch3 == 'y'));

        /* 4. 영문자인지 확인 */
        /* A : 65, Z :90, a:97, z:122(중간의 91~96까지는 영문자가 아님) */
        char ch5 = 'f';
        System.out.println("영문자인지 확인 : " + ((ch5 >= 'A' && ch5 <= 'z') || (ch5 >= 'a' && ch5 <= 'z')));
        System.out.println("영문자인지 확인 : " + ((ch5 >= 65 && ch5 <= 90) || (ch5 >= 97 && ch5 <= 122)));

        char ch6 = 24;
        System.out.println("영문자인지 확인 : " + ((ch6 >= 'A' && ch6 <= 'z') || (ch6 >= 'a' && ch6 <= 'z')));
        System.out.println("영문자인지 확인 : " + ((ch6 >= 65 && ch6 <= 90) || (ch6 >= 97 && ch6 <= 122)));
    }
}
