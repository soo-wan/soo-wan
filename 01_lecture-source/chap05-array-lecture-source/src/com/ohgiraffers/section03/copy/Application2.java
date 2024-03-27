package com.ohgiraffers.section03.copy;

public class Application2 {
    public static void main(String[] args) {
        /* 얕은 복사를 활용하여 매개변수와 리턴값으로 활용할 수 있다. */
        
        /*
        * 얕은 복사의 활용
        * 얕은 복사를 활용하는 것은 주로 메소드 호출시 인자로 사용하는 경우와
        * 리턴값으로 동일한 배열을 리턴해주고 싶은 경우 사용한다.
        * */
        
        String[] name = {"홍길동", "유관순", "이순신"};

        System.out.println("name.hashCode() = " + name.hashCode()); //1283928880

        /* 1. 인자와 매개변수로 활용 */
        print(name); //static이여서 바로 호출

        /* 2. 리턴 값으로 활용 */
        String[] animals = getAnimals(); // static이여서 바로 호출

        /* (수업 외) static 아니면 객체 생성후 이렇게 호출 */
        //Application2 ap = new Application2();
        //ap.getAnimals();

        System.out.println("리턴 받은 animals.hashCode() = " + animals.hashCode());

        print(animals);
    }

    public static void print(String[] sarr){
        System.out.println("sarr.hashCode() = " + sarr.hashCode());
        for(int i = 0; i < sarr.length; i++){
            System.out.print(sarr[i] + " ");
        }
        System.out.println();
    }

    public static String[] getAnimals(){ //static
        String[] animals = new String[]{"뱀", "판다", "다람쥐"};
        //String[] animals - (stack), new 연산자, String[]{"뱀", "판다", "다람쥐"} - (heap)
        System.out.println("새로만든 animals의 hascode = " + animals.hashCode());

        return animals;
    }

}
