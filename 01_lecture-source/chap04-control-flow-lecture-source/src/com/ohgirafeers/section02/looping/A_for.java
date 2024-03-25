package com.ohgirafeers.section02.looping;

import java.util.Scanner;

public class A_for {
    public void testSimpleForStatement(){
        /* 수업 목표 for 단독 사용에 대해 흐름을 이해하고 적용할 수 있다. */
        /*
        * [for문 표현식]
        * for(초기식; 조건식; 증감식) {
        *   조건을 만족하는 경우 수행할 구문(반복할 구문)
        * }
        * */

        /* 1부터 10까지 1씩 증가시키며 10번 i 값을 증가시키는 기본 반복문 */
        for(int i=0; i<=10; i++){
            System.out.println(i);
        }

        int j = 1;
        for(; j<=15; ){ // 조건식은 빼지못함.(무한 루프) 다른건 빼서 다른곳에서 초기화 해도 됨.
            System.out.println(j);
            j++;
        }
    }

    public void testForExample1(){
        /* 우리가 뭘 반복하는지 확인하여 반복문으로 개선할 수 있다. */
        /* 10명의 학생의 이름을 입력 받아 이름을 출력해보자 */
        Scanner sc = new Scanner(System.in);

        /*
        System.out.println("1 번째 학생의 이름을 입력해주세요 : ");
        String student1 = sc.nextLine();
        System.out.println("1 번째 학생의 이름은 " + student1 + "입니다.");
        */

        /*
         * 반복해야하는 내용은?
         * 1. 학생의 이름을 입력받아 변수에 저장
         * 2. 안내문구 출력
         * 3. 저장된 이름 출력
         * */
        /* 반복 횟수 1~10까지 1씩 증가하여 총 10번을 반복하였다. */
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "번째 학생의 이름을 입력해주세요 : ");
            String student1 = sc.nextLine();
            System.out.println(i + "번째 학생의 이름은 " + student1 + "입니다.");
        }
    }

    public void testForExample2() {
        /* 우리가 뭘 반복하는지 확인하여 반복문으로 개선할 수 있다.(2) */
        /* 문장 속에 규칙 찾기
        *1~10까지의 합계를 구하라
        * */
        int sum = 0;
        for (int i=1; i<=10; i++){
            sum += i; //sum = sum + i;
        }
        System.out.println("sum = " + sum);
    }

    public void testForExample3() {
        /* 우리가 뭘 반복하는지 확인하여 반복문으로 개선할 수 있다.(3) */
        /* 5 ~10 사이의 난수를 발생시켜서
        * 1부터 발생한 난수까지의 합계를 구해보자.
        * */
        /**/
        int random = (int) (Math.random() * 6) + 5;

        System.out.println("random : " + random);

        /* 뭔가 더해서 담기 위해 sum 변수를 0으로 초기화 */
        int sum = 0;


        if(random == 5) {
            sum += 1;
            sum += 2;
            sum += 3;
            sum += 4;
            sum += 5;
        } else if(random == 6) {
            sum += 1;
            sum += 2;
            sum += 3;
            sum += 4;
            sum += 5;
            sum += 6;
        } else if(random == 7) {
            sum += 1;
            sum += 2;
            sum += 3;
            sum += 4;
            sum += 5;
            sum += 6;
            sum += 7;
        } else if(random == 8) {
            sum += 1;
            sum += 2;
            sum += 3;
            sum += 4;
            sum += 5;
            sum += 6;
            sum += 7;
            sum += 8;
        } else if(random == 9) {
            sum += 1;
            sum += 2;
            sum += 3;
            sum += 4;
            sum += 5;
            sum += 6;
            sum += 7;
            sum += 8;
            sum += 9;
        } else {
            sum += 1;
            sum += 2;
            sum += 3;
            sum += 4;
            sum += 5;
            sum += 6;
            sum += 7;
            sum += 8;
            sum += 9;
            sum += 10;
        }

        System.out.println("1부터 " + random + "까지의 합은 : " + sum);

        /* 반복문을 이용한 개선 */
        int sum2 = 0;

        for(int i = 1; i<= random; i++){
            sum2 += i;
        }
        System.out.println("1부터 " + random + "까지의 합은 : " + sum2);
    }
    public void printSimpleGugudan(){
        /* 수업목표. 무엇을 반복하는지 확인하여 반복문으로 개선할 수 있다. */
        /*
        키보드로 2~9사이에 구구단을 입력받아
        2~9사이에 경우 해당 단의 구구단을 출력하고
        그렇지 않은 경우 "반드시 2~9 사이의 양수를 입력해야합니다." 출력
        * */

        Scanner sc = new Scanner(System.in);
        System.out.print("출력할 구구단의 단 수를 입력하세요. : ");
        int dan = sc.nextInt();

        if(dan >=2 && dan <= 9){
            for(int su=1; su<=9; su++){
                System.out.println(dan + "*" + su + " = " + (dan*su));
            }
        } else {
            System.out.println("반드시 2~9사 사이의 양수를 입력해야합니다.");
        }
        System.out.println("프로그램을 종료합니다.");
    }
}

