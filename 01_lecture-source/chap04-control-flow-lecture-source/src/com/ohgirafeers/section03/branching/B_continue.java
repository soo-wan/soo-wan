package com.ohgirafeers.section03.branching;

public class B_continue {
    /* 수업 목표. continue문 사용에 대한 흐름을 이해하고 적용할 수 있다. */
    /*
    * continue문은 반복문 내에서 사용한다.
    * 해당 반복문의 반복 회차를 중간에 멈추고 다시 증감식으로 넘어가게 해준다.
    * 일반적으로 if(조건식){continue;}처럼 사용한다.
    * 보통 반복문 내에서 특정 조건에 대한 예외를 처리하고자 할 때 자주 사용한다.
    * */

    /* 1부터 100사이의 4의 배수이면서 5의 배수인 값을 출력 */
    public void testSimpleContinueStatement() {
        /*
        for (int i = 1; i <= 100; i++) {
            if(i % 4 == 0 && i % 5 == 0) {
                System.out.println(i);
            }
        }
        */
        for(int dan = 2; dan < 10; dan++){
            /* 설명. 여기까지 빠져나옴 */
            for(int su = 1; su < 10; su++){
                if(su % 2 == 0){
                    /*  su가 짝수인 경우 해당 회차 반복 내용을 건너 뛰고 증감식으로 이동 */
                    continue; //PASS
                }
                System.out.println(dan + " * " + su + " = " + dan * su);
            }
            System.out.println();
        }
    }
}
