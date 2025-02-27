package prototype.ex02;

// Cloneable 인터페이스를 상속해 복제가 가능하게 합니다.
public interface Product extends Cloneable{
    abstract void use(String s);
    abstract  Product createClone();
}
