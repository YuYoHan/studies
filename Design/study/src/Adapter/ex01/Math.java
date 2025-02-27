package Adapter.ex01;

// 어댑터 패턴(Adapter Pattern)
// 클라이언트의 요구 타입과 반환타입이 다를지라도
// 중간에 어댑터를 둠으로써 적적히 가공하여 둘을 연결지어준다는 것이다.
public class Math {
    // 2배를 반환
    public static double twoTime(double num) {
        return num * 2;
    }
    // ½을 반환
    public static double half(double num) {
        return num / 2;
    }
}
