package com.ohgiraffers.Section04.overflow;

public class Application1 {
    public static void main(String[] args) {
        /* 수업 목표. 오버플로우에 대해 이해할 수 있다. */
        /* 자료형의 값의 최대 범위를 벗어나는 경우
        *  발생한 carry를 버림 처리하고 sign bit를 반전시켜 최소값으로 순환시킴
        * */

        /* 1. 오버플로우 */
        byte num1 = 127;
        System.out.println("num1 : " + num1);

        num1++;  //1이 증가

        System.out.println("num1 오버플로우 : " + num1); // -128 , 오버플로우 발생

        /* 2. 언더플로우 */
        /* 오버플로우와 반대의 개념으로 최소 범위보다 작은 수를 발생시키는 경우 발생하는 현상이다. */
        byte num2 = -128;
        System.out.println("num2 : " + num2);

        num2--;  //1이 증가

        System.out.println("num2 언더플로우 : " + num2); // 127 , 언더플로우 발생, 최대값으로 순환

        int firstNum = 1000000; //100만
        int secondNum = 700000; //70만

        int multi = firstNum * secondNum; //7천억이 나와야함

        System.out.println("firstNum * secondNum =  "  + multi);

        /* 3. 해결 방법 */
        /* 오버플로우를 예측하고 더 큰 자료형으로 결과값을 받아서 처리한다. */

        //long firstNum2 = 1000000; //100만
        //long secondNum2 = 700000; //70만

        long longMulti = firstNum * secondNum;
        System.out.println(longMulti); // 왜 안되지 왜 똑같지

        long result = (long)firstNum * secondNum; //강제 형 변환

        System.out.println("result : " + result);

    }
}
