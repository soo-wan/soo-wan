package com.ohgirafeers.section03.branching;

public class A_break {
    public void testSimpleBreakStatement(){
        /* 수업 목표. break문 사용에 대한 흐름을 이해하고 적용할 수 있다. */

        /*
         * break문은 반복문 내에서 사용한다.
         * 해당 반복문을 빠져 나올 때 사용하며, 반복문의 조건문 판단 결과와 상관없이 반복문을 빠져 나올 때 사용한다.
         * 일반적으로 if(조건식) {break;}처럼 사용한다.
         * 단 switch문은 반복문이 아니지만 예외적으로 사용한다.
         * */

        /* break문을 이용하여 무한루프를 활용한 1~100까지의 합계 구하기 */

        int sum = 0;
        int i = 1;
        while(true){
            sum += i;

            if(i==100){
                break;
            }
            i++;
        }
        System.out.println("1부터 100까지의 합은 " + sum + "입니다.");
    }

    public void testSimpleBreakStatement2(){
        /* 수업목표. 중첩 반복문 내 break문 사용에 대한 흐름을 이해하고 적용할 수 있다 */
        /* break문은 모든 반복문을 종료하는 것이 아닌 자신에게 가장 인접한 반복문의 실행을 멈춘다. */
        /*
        * 구구단 2~9단까지 출력
        * 단, 각 단의 수가 5보다 큰 경우 해당 반복문을 빠져나온다.(출력울 생략한다)
        * */

        for(int dan = 2; dan < 10; dan++){
            for(int su = 1; su < 10; su++){
                if(su > 5){
                    break; //멈춤
                }
                System.out.println(dan + " * " + su + " = " + (dan*su));
            }
            System.out.println();
        }
    }
}
