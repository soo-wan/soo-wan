package com.ohgiraffers.section01.method;

public class Application7 {
    public static void main(String[] args) {
        /* 수업 목표. 매개변수와 리턴값을 복합적으로 활용하는 것을 이해하고 활용할 수 있다 */
        /*
        * 매개변수와 리턴값 복합 활용
        * 매개변수도 존재하고 리턴값도 존재하는 메소드를 이욯하며 간단한 계산기 만들기
        * */

        int first = 20;
        int second = 10;
        Application7 app7 = new Application7();
        System.out.println("두 수를 더한 결과 : " + app7.plusTwoNum(first, second));
        System.out.println("두 수를 뺀 결과 : " + app7.minusTwoNum(first, second));
        System.out.println("두 수를 곱한 결과 : " + app7.multipleTwoNum(first, second));
        System.out.println("두 수를 나눈 결과 : " + app7.divideTwoNum(first, second));
    }

    public int plusTwoNum(int first, int second){

        return first + second;
    }

    public int minusTwoNum(int first, int second){
        return first - second;
    }

    public int multipleTwoNum(int first, int second){
        return first * second;
    }

    public int divideTwoNum(int first, int second){
        return first / second;
    }
}
