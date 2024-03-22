package com.ohgiraffers.section03.math;

import java.util.Random;

public class Application3 {
    public static void main(String[] args) {
        /* 수업목표. java.util.Random 클래스를 활용하여 사용자 범위의 난수를 발생시킬 수 있다.
        *
        * java.util.Random 클래스
        * java.util.Random 클래스 nextInt()메소드를 이용한 난수 발생
        * nextInt(int bound) : 0부터 매개변수로 전달 받은 정수 범위까지의 난수를 발생시켜서 정수 형태로 반환
        * */
        /* random.nextInt(구하려는 난수의 갯수) + 구하려는 난수의 최소값 */

        Random random = new Random();

        /* 1. 0부터 9까지 난수발생 */
        int randomNum = random.nextInt(10);
        System.out.println("0부터 9까지의 난수 ? : " + randomNum);

        /* 2. 1부터 10까지의 난수발생 */
        int randomNum1 = random.nextInt(10) + 1;
        System.out.println("1부터 10까지의 난수 ? : " + randomNum1);

        /* 3. 20부터 45까지의 난수 발생 */
        int randomNum2 = random.nextInt(26) + 20;
        System.out.println("20부터 45까지의 난수 ? : " + randomNum2);

        /* 4. -128 ~ 127까지의 난수 발생 */
        //int randomNum3 = random.nextInt(256) -128 ;
        int randomNum3 = new Random().nextInt(256) -128 ;
        System.out.println("-128부터 127까지의 난수 ? : " + randomNum3);
    }
}
