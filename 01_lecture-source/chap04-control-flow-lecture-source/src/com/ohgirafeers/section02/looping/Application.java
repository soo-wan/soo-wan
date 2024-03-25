package com.ohgirafeers.section02.looping;

public class Application {
    public static void main(String[] args) {
        A_for a = new A_for();
        //a.testSimpleForStatement();
        //a.testForExample1();
        //a.testForExample2();
        //a.testForExample3();
        //a.printSimpleGugudan();

        A_nestedfor an = new A_nestedfor();
        //an.printGugudanFromTwoNice();
        //an.printStarInputRowTimes();
        //an.printTriangleStarts();

        B_while b = new B_while();
        //b.testSimpleWhileStatement();
        //b.testWhileExample();
        //b.testWhileExample2();

        C_doWhile c = new C_doWhile();
        //c.testSimpleDoWhileStatement();
        c.testDoWhileExample();
    }
}
