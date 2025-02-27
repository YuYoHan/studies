package prototype;


// Cloneable 인터페이스를 상속한 Product 인터페이스는 복제를 가능하게 합니다.
// 이 인터페이스를 구현하는 클래스의 인터페이스는 clone 메소드를 사용해서 자동으로 복제할 수 있게 됩니다.
public interface Product extends Cloneable{
    public abstract void use(String s);
    public abstract Product createCopy();
}
