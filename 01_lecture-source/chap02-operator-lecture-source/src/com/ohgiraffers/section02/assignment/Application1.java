package com.ohgiraffers.section02.assignment;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 대입연산자와 산술 복합 대입 연산자를 이해하고 활용할 수 있다.
        * 대입연산자와 산술복합 대입 연산자
        * '=' : 왼쪽에 피연산자에 오른쪽의 피연산자를 대입함
        * '+=' : 왼쪽에 피연산자에 오른쪽의 피연산자를 더한 결과를 왼쪽 피연산자에 대입함
        * '-=' : 왼쪽에 피연산자에 오른쪽의 피연산자를 뺀 결과를 왼쪽 피연산자에 대입함
        * '*=' : 왼쪽에 피연산자에 오른쪽의 피연산자를 곱한 결과를 왼쪽 피연산자에 대입함
        * '/=' : 왼쪽에 피연산자에 오른쪽의 피연산자를 나눈 결과를 왼쪽 피연산자에 대입함
        * '%=' : 왼쪽에 피연산자에 오른쪽의 피연산자를 나눈 나머지 결과를 왼쪽 피연산자에 대입함
        * */

        int num = 12;
        System.out.println("num : " + num);

        //3 증가시
            num = num + 3; // 대입연산자의 오른쪽은 값 왼쪽에는 공간의 의미다.
        System.out.println("num : " + num); //15
            num += 3; // num = num + 3과 같은 의미.
        System.out.println("num : " + num); //18
        num -= 5; // num = num -5
        System.out.println("num : " + num); //13
        num *= 2; // num값이 2배 증가
        System.out.println("num : " + num); //26
        num /= 2;
        System.out.println("num : " + num); //13
        num %= 3;
        System.out.println("num : " + num); //1

        /* 주의사항
        * 산술 복합 대입연산자의 작성 순서에 주의해야한다.
        * */
        num =- 5;
        System.out.println("num : " + num); //-5

    }
}
