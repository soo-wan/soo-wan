package com.ohgiraffers.section02.variable;

public class Application1 {
    public static void main(String[] args) {
        /* 변수의 사용 목적을 이해할 수 있다 */
        /* 변수의 사용 목적 */
        /*
        * 1. 값에 의미를 부여하기 위한 목적(의미 전달이 쉬워야 코드가 읽기 쉬워지고, 협업 및 유지보수에 유리하기 때문이다.)
        * 2. 한 번 저장해둔 값을 재사용하기 위한 목적(변수를 이용하여 코드를 작성하면, 값을 변경할 때도 보다 간편하게 변경할 수 있다)
        * 3. 시간에 따라 변하는 값을 저장하고 사용할 수 있다.(변하는 값을 저장하기 위한 공간이다)
        * */

        /* 1. 값에 의미부여를 하기 위한 목적 */
        System.out.println("==================값에 의미 부여 테스트 ==================");
        System.out.println("보너스를 포함한 급여 : " + (10000000 + 20000000) + "원");

        int salary = 5000000;
        int bonus = 20000000;

        int salary2;
        salary2 = 100;

        System.out.println( "보너스를 포함한 급여 : " + ( salary +  bonus ) + "원");

        /* 2. 한번 저장해둔 값을 재사용하기 위한 목적 */
        System.out.println( "==================분수의 저장한 값 재사용 테스트==================" );
        System.out.println("1번의 고객에게 포인트를 100포인트 지급하였씁니다.");
        System.out.println("2번의 고객에게 포인트를 100포인트 지급하였씁니다.");
        System.out.println("3번의 고객에게 포인트를 100포인트 지급하였씁니다.");
        System.out.println("4번의 고객에게 포인트를 100포인트 지급하였씁니다.");
        System.out.println("5번의 고객에게 포인트를 100포인트 지급하였씁니다.");

        int point = 1000;
        System.out.println( "==================변수 사용==================" );
        System.out.println("1번의 고객에게 포인트를 " + point + "포인트 지급하였씁니다.");
        System.out.println("2번의 고객에게 포인트를 " + point + "포인트 지급하였씁니다.");
        System.out.println("3번의 고객에게 포인트를 " + point + "포인트 지급하였씁니다.");
        System.out.println("4번의 고객에게 포인트를 " + point + "포인트 지급하였씁니다.");
        System.out.println("5번의 고객에게 포인트를 " + point + "포인트 지급하였씁니다.");

        /* 3. 시간에 따라 변경되는 값을 정하고 사용할 수 있다. */
        System.out.println("==================변수에 저장된 값 변경 테스트==================" );
        int sum = 0;

        sum = sum + 10;
        System.out.println("sum에 10을 더하면 현재의 sum의 값은?" + sum);
        sum = sum + 10;
        System.out.println("sum에 10이 있었으니 10을 추가로 더하면 sum의 값은?" + sum);
        sum = sum + 10;
        System.out.println("sum에 20이 있었으니 10을 추가로 더하면 sum의 값은?" + sum);
    }
}
