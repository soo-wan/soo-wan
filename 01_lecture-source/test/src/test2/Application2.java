package test2;

import test1.TestMethod;

import static test1.TestMethod.testRandom;

public class Application2 {
    public static void main(String[] args) {
        TestMethod test = new TestMethod();

        test.calculator(2,5);

        double db = test.circleArea();

        System.out.println("원의 넓이는 " + db + "입니다");

        String str = testRandom();
        System.out.println(str);

    }
}
