package com.ohgiraffers.section02.package_and_import;

import com.ohgiraffers.section01.method.Calculator;

import static com.ohgiraffers.section01.method.Calculator.maxNumberOf;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. import(임포트)에 대해 이해할 수 있다. */
        /*
        임포트란?
        서로 다른 패키지에 존재하는 클래스를 사용하는 경우 패키지명을 포함한 풀 클래스 이름을 사용해야한다.
        하지만 매번 다른클래스의 패키지명까지 기술하기에는 번거롭다.
        그래서 패키지명을 생략하고 사용할 수 있도록 한 구문이 import문이다.
        import는 package 선언문과 class 선언문 사이에 작성하며
        어떠한 패키지 내에 클래스를 사용할 것인지 선언하는 효과를 가진다.
        * */

        /* 1. non-static method의 경우 */
        Calculator cal = new Calculator();
        int result = cal.minNumberOf(50,60);
        System.out.println("50과 60의 최소값은? " + result);

        /* 2. static의 경우 */
        int result2 = Calculator.maxNumberOf(50,60);
        System.out.println("50과 60의 최대값은? " + result2);

        /* import를 하면 static 메소드를 호출할 때 클래스명을 생략하고 사용할 수 있다. */
           //import static com.ohgiraffers.section01.method.Calculator.maxNumberOf;
        int max2 = maxNumberOf(50,60); // static 메소드 수동 추가
    }
}
