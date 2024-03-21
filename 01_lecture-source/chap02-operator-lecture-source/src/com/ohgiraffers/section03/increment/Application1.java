package com.ohgiraffers.section03.increment;

public class Application1 {
    public static void main(String[] args) {
        /* 증감연산자에 대해 이해하고 활용할 수 있다.
        * 증감연산자
        * 피연산자의 앞 or 뒤에 사용이 가능하다.
        * '++' : 1 증가의 의미
        * '--' : 1 감소의 의미
        * */

        /* 목차 1. 증감연산자를 단독으로 사용 */
        /* 단항으로 사용될 때는 1증가/1감소의 의미를 가진다. */
        int num = 20;
        System.out.println("num :" + num);

        num++;
        System.out.println("num :" + num);

        ++num;
        System.out.println("num :" + num);

        num--;
        System.out.println("num :" + num);

        --num;
        System.out.println("num :" + num);

        /* 증감연산자를 다른 연산자와 사용
        * 주의사항
        * 증감연산자를 다른 연산자와 함께 사용할 때 의미가 달라진다.
        * 다른 연산자와 함께 사용할 때 증감 연산자의 의미
        * 'num ++' : 다른 연산 먼저 진행하고 난 뒤 마지막에 피연산자의 값을 1증가 시킴.
        * '++num '
        * */
        int firstNum = 20;
        int result = firstNum++ * 3; // ★★★ 다른 연산을 먼저 처리하고 난 뒤 마지막에 firstNum을 증가 처리함
        System.out.println("result = " + result); //60
        System.out.println("result = " + firstNum); //21

        int secondNum = 20;
        int result1 = ++secondNum * 3; // 먼저 더하기 처리하고 다른 연산 처리함
        System.out.println(result1); //63

        int num1 = 10;
        int result2 = --num1 * 3;

        System.out.println("result2 = " + result2); //27
        System.out.println("num1 = " + num1); //9

        int num2 = 10;
        int result3 = num2-- * 3;

        System.out.println("result3 = " + result3); //30
        System.out.println("num2 = " + num2); //9
    }
}
