package com.ohgiraffers.section02.demensinal;

public class Application4 {
    public static void main(String[] args) {
        /* 수업목표. 2차원 배열의 선언과 할당 및 초기화를 동시에 할 수 있다. */
        /* 2차원 배열도 할당과 동시에 기본값 외에 값으로 초기화 하고 싶은 경우 리터럴을 이용할 수 있다. */
        /* 1. 선언과 할당을 하며 초기화 */
        /* 1-1. 정변 배열 */
        int[][] iarr = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}}; // == int[3][5]

        for(int i=0; i < iarr.length; i++){
            for(int j=0; j < iarr[i].length; j++){
                System.out.print(iarr[i][j] + " ");
            }
            System.out.println();
        }

        /* 1-2. 가변 배열 */
        int[][] iarr2 = {{1,2,3,4},{5,6,7},{8,9}};

        for(int i=0; i<iarr2.length; i++){
            for(int j=0; j < iarr2[i].length; j++){
                System.out.print(iarr2[i][j] + " ");
            }
            System.out.println();
        }

        /* 1-3 미리 할당한 배열을 이용한 방식 */
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {6,7,8,9,10};
        int[][] iarr3 = {arr1,arr2}; //int[2][5]

        for(int i=0; i<iarr3.length; i++){
            for(int j=0; j < iarr3[i].length; j++){
                System.out.print(iarr3[i][j] + " ");
            }
            System.out.println();
        }

    }
}
