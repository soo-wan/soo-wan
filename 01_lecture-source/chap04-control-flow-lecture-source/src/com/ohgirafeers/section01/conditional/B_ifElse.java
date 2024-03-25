package com.ohgirafeers.section01.conditional;

import java.util.Scanner;

public class B_ifElse {
    public void simpleIfElseStatement(){
        /* 수업 목표. if-else문 단독 사용에 대한 흐름을 이해하고 적용할 수 있다. */
        /*
        * [if-else 표현식]
        * if(조건식){
        *   조건식이 true일 때 실행할 명령문;
        * } else {
        *   조건식이 false일 때 실행할 명령문;
        * }
        * */

        /* if문은 조건식의 결과가 참이면 if{}안에 있는 코드를 실행하고
        * 조건식의 결과가 거짓이면 else{} 안에 있는 코드를 실행한다.
        * */

        /* 정수 한 개를 입력받아 그 수가 홀수이면 "입력하신 숫자는 홀수입니다"를 출력하고
        * 홀수가 아니면 "입력하신 숫자는 짝수입니다"를 출력하는 프로그램을 작성해보자
        * 단 조건과 관련없이 프로그램이 종료될 때 프로그램을 종료합니다라고 출력되도록 하자.
        * */

        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 하나를 입력해주세요 : ");
        int num = sc.nextInt();

        if(num % 2 != 0){
            System.out.println("입력하신 숫자는 홀수입니다");
        } else{
            System.out.println("입력하신 숫자는 짝수입니다");
        }

        System.out.println("프로그램을 종료합니다");
    }

    public void testNeatedIfStatement() {
        /* 수업 목표. 중첩된 if-else 문의 흐름을 이해하고 적용할 수 있다. */
        /* 중첩된 if-else문 실행 흐름 확인 */
        /*
         * 숫자를 하나를 입력받아 양수이면 "입력하신 숫자는 양수입니다"를 출력하고
         * 음수이면 "입력하신 숫자는 음수입니다"를 출력
         * 단, 0이면 "0입니다"라고 출력하세요.
         * 조건과 관련없이 프로그램이 종료될 때 프로그램을 종료합니다라고 출력되도록 하자.
         * */

        Scanner sc = new Scanner(System.in);
        System.out.print("정수 하나를 입력하세요 : ");
        int num = sc.nextInt();

        /*
        if (num > 0) {
            System.out.println("입력하신 숫자는 양수입니다.");
        } else if (num < 0) {
            System.out.println("입력하신 숫자는 음수입니다.");
        } else {
            System.out.println("0입니다.");
        }
        */

        if (num != 0) {
            if (num > 0) {
                System.out.println("입력하신 숫자는 양수입니다.");
            } else {
                System.out.println("입력하신 숫자는 음수입니다.");
            }
        } else {
            System.out.println("입력하신 숫자는 0입니다.");
        }

        System.out.println("프로그램을 종료합니다.");
    }


}
