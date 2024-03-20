package com.ohgiraffers.section01.literal;

public class Application1 {
        public static void main(String[] args){
            /*  수업목표. 여러 가지의 값의 형태를 출력할 수 있다.

               1. 숫자 형태의 값
               1-1 정수 형태의 값
            */
                System.out.println(1234); //1234 정수
            /* 1-2 실수 형태의 값 */
                System.out.println(1.23); //1.23 실수
            /* 2. 문자 형태의 값 출력 */
                System.out.println('a'); //문자 형태의 값 홀따옴표(single quotation)으로 감싸주어야 한다.
                //System.out.println('ab'); // 두 개 이상은 문자로 취급하지 않기 때문에 에러가 발생한다.
                //System.out.println(''); // 아무 문자도 기록되지 않는 경우 에러가 발생한다.
                System.out.println('1'); // 숫자값이지만 홀따옴표로 감싸져 있는 경우 문자 1'로 판단한다.
                System.out.println('남');
            /* 3. 문자열 형태의 값 출력 */
                System.out.println("안녕하세요"); // 문자열 문자 여러개가 나열된 형태를 말하며 쌍따옴표(double quotation)으로 감싸주어야 한다.
                System.out.println("123"); //정수 이지만  쌍따옴표로 감싸져있기때문에 문자열로 보아야함.
                System.out.println(" "); // 아무것도 없는 빈 쌍따옴표도 문자열로 취급한다.
                System.out.println("a"); // 한 개의 문자도 쌍따옴표로 감싸면 문자열이다.(문자 a와는 다르다.)
            /* 4. 논리 형태의 값 출력 */
                // 참이냐 거짓이냐
                System.out.println(true); // 참
                System.out.println(false); // 거짓

                //true 혹은 false 값을 논리형이라고 한다.
        }
}
