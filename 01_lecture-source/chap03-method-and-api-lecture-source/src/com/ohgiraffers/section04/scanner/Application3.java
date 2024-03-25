package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        /* 수업목표 스캐너 사용 시 주의 사항에 대해 이해하고 사용시 주의 사항은 고려하여 사용할 수 있다. */
        /* 스캐너의 next 메소드들은 입력한 내용을 버퍼로부터 토큰단위로 분리해서 읽어온다
        * 그래서 크게 두 가지 사항을 주의해야한다.
        * 1. next()로 문자열 입력을 받은 후 정수, 실수, 논리값을 받을 때
        * 2. 정수, 실수, 논리값 입력 후 nextLine()로 문자열을 받을 때
        * */
        
        /* 스캐너 객체 생성 */
        Scanner sc = new Scanner(System.in);
        
        /* 1. next()로 문자열 입력을 받은 후 정수, 실수, 논리값을 받을 때 */
        System.out.print("문자열을 입력해주세요 : "); //안녕하세요 반갑습니다. 쓰면 오류. 숫자로 받아야하는데 공백이후 2토큰으로 문자로 받아서.
        String str1 = sc.next();
        System.out.println("str1 = " + str1);//soutv

        sc.nextLine(); //해결 방법, clear 기능

        System.out.print("숫자를 입력해주세요 : ");
        int num1 = sc.nextInt();
        System.out.println("num1 = " + num1);

        /* 2. 정수, 실수, 논리값 입력 후 nextLine()로 문자열을 받을 때 */
        System.out.print("다시 숫자를 입력해주세요 : ");
        int num2 = sc.nextInt();
        System.out.println("num2 = " + num2);

        System.out.print("공백이 있는 문자열을 하나 입력해주세요 : ");

        sc.nextLine(); //이게 없으면 숫자입력하고 끝남.

        String str2 = sc.nextLine();
        System.out.println("str2 = " + str2);

    }
}
