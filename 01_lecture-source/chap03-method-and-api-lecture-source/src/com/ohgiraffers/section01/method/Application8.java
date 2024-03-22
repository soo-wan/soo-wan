package com.ohgiraffers.section01.method;

public class Application8 {
    public static void main(String[] args) {
        /* static 메소드를 호출할 수 있다. */
        /* static 메소드를 호출하는 방법
        * 클래스명.메소드명(); <-- 이런 방식으로 호출한다.
        * */

        System.out.println("10과 20의 합 : " + Application8.sumTwoNum(10,20));

        //1.(동일한 클래스) 내에 작성된 2.(static 메소드)는 클래스명 생략이 가능하다.

        System.out.println("10과 20의 합 : " + sumTwoNum(10,20));
    }
    public static int sumTwoNum(int first, int second){
        return first + second;
    }
}
