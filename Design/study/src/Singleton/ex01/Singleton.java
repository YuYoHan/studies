package Singleton.ex01;

// 싱글톤의 역할로서 유일한 인스턴스를 반환하기 위한 역할을 하고 있다.
// 이렇게 하는 이유는 복수의 인스턴스가 존재하게 되면 서로 영향을 미치고
// 사이드 이펙트가 발생할 수 있기 때문이다.
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("create singleton");
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
