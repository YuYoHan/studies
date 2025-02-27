package Adapter.ex01;

public class Main {
    public static void main(String[] args) {
        // 이렇게 처리하면 장점이 내부에서 어떠한 알고리즘을 사용하던
        // 사용자는 사용방법이 크게 달라지지 않습니다.
        // 즉, 생산성이 높아질 수 있습니다.
        Adapter adapter = new AdapterImpl();
        System.out.println(adapter.twiceOf(100f));
        System.out.println(adapter.halfOf(50f));
    }
}
