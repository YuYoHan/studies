package Singleton.ex01;

public class Main {
    public static void main(String[] args) {
        System.out.println("start");
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println("s1과 s2의 동일성 비교 :" + (s1 == s2));  // true
        System.out.println("end");
    }
}
