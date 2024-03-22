package com.ohgiraffers.section02.package_and_import;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 패키지에 대해 이해할 수 있다. */
        /* 패키지란?
        *  서로 관련된 클래스 또는 인터페이스 등을 모아 하나의 묶음(그룹)으로 단위를 구성하는 것을 말한다.
        *  같은 패키지 내에서는 동일한 이름의 클래스를 만들 수 없지만, 패키지가 다르면 동일한 이름을 가진 클래스를 만들 수도 있다.
        * 클래스명은 원래 패키지명을 포함 되어있기 때문이다. 예)com.ohgiraffers.section01.method.Calculator (이게 클래스명이다)
          지금까지 클래스명에 패키지명을 함께 사용하지 않은 이유는 동일한 패키지 내에서 사용했기 때문이다.
          그렇기 때문에 서로 다른 패키지에 클래스를 사용하는 경우에는 클래스 명 앞에 패키지명을 명시해서 풀 클래스 이름으로 사용해야한다.
        * */
        /* 1. non-static 메소드의 경우 */
        com.ohgiraffers.section01.method.Calculator cal = new com.ohgiraffers.section01.method.Calculator();

        int min = cal.minNumberOf(30,20);

        System.out.println("30과 20중에 더 작은 값은? " + min);

        /* static 메소드의 경우 */

        int max = com.ohgiraffers.section01.method.Calculator.maxNumberOf(30,20);
        System.out.println("30과 20중에 더 큰 값은? "  + max);

    }
}
