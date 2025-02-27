package Factory.ex02;

// 이 패턴에서 생성되는 인스턴스가 가져야
// 할 인터페이스(API)를 결정하는 것은 추상 클래스입니다.
public abstract class Product {
    abstract void use();
}
