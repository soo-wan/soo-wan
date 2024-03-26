package com.ohgiraffers.section02.demensinal;

public class Application2 {
    public static void main(String[] args) {
        /* 수업 목표. 2차원 정변배열을 선언 및 할당하여 사용할 수 있다. */
        /* 1. 배열의 선언 및 할당 */
        /* 정변 배열의 경우 각 인덱스별 배열을 따로 할당할 수도 있지만 선언과 동시에 모든 배열을
        * 할당할 수 있다.
        * 자료형[][] 변수명 = new 자료형[할당할 배열의 갯수][할당할 배열의 길이]
        * */

        int[][] iarr = new int[3][5]; //길이 5의 배열을 3개 할당하고 그 주소를 묶어 관리하는 배열의 주소를 stack의 iarr에 저장한다.

        /* 2. 각 배열의 인덱스에 접근해서 값 대입 후 출력 */
        iarr[0][0] = 1;
        iarr[0][1] = 2;
        iarr[0][2] = 3;
        iarr[0][3] = 4;
        iarr[0][4] = 5;

        iarr[1][0] = 6;
        iarr[1][1] = 7;
        iarr[1][2] = 8;
        iarr[1][3] = 9;
        iarr[1][4] = 10;

        iarr[2][0] = 11;
        iarr[2][1] = 12;
        iarr[2][2] = 13;
        iarr[2][3] = 14;
        iarr[2][4] = 15;

        System.out.print(iarr[0][0] + " ");
        System.out.print(iarr[0][1] + " ");
        System.out.print(iarr[0][2] + " ");
        System.out.print(iarr[0][3] + " ");
        System.out.print(iarr[0][4] + " ");

        System.out.println();

        System.out.print(iarr[1][0] + " ");
        System.out.print(iarr[1][1] + " ");
        System.out.print(iarr[1][2] + " ");
        System.out.print(iarr[1][3] + " ");
        System.out.print(iarr[1][4] + " ");

        System.out.println();

        System.out.print(iarr[2][0] + " ");
        System.out.print(iarr[2][1] + " ");
        System.out.print(iarr[2][2] + " ");
        System.out.print(iarr[2][3] + " ");
        System.out.print(iarr[2][4] + " ");

        System.out.println();

        /* 2-2 반복문을 이용하여 값 대입후 출력 */
        int[][] iarr2 = new int[3][5];
        int value = 0;

        for(int i=0; i < iarr2.length; i++){ //3
            for(int j=0; j < iarr2[i].length; j++){ //5
                //iarr2[i][j] = value ++;
                iarr2[i][j] = ++ value;
                System.out.print(iarr2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
