package Strategy.ex01;

// 전략 패턴
// 여러 알고리즘을 하나의 추상적인 접근점(인터페이스)을 만들어
// 접근점에서 서로 교환 가능하도록 하는 패턴
public interface Weapon {
    // 추상 메서드 생성
    public void attack();
}
