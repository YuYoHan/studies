package Strategy.ex02;

public interface PaymentStrategy {
    // 상속받을 클래스에서 사용할 메서드
    public void pay(int amount);
}
