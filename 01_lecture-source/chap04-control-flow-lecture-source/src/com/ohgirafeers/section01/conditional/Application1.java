package com.ohgirafeers.section01.conditional;

public class Application1 {
    public static void main(String[] args) {
        A_if a = new A_if();
        /* 단독 if 문 흐름 확인용 메소드 출력 */
        //a.testSimpleIfStatement();

        /* */
        //a.testNestedIfStatement();

        B_ifElse b = new B_ifElse();
        //b.simpleIfElseStatement();
        //b.testNeatedIfStatement();

        C_ifElseif c = new C_ifElseif();
        //c.testSimpleIfElseStatement();
        //c.testNestedIfElseIfStatement();

        D_switch d = new D_switch();
        //d.testSimpleSwitchStatement();
        //d.testSwitchVendingMachine();

    }
}
