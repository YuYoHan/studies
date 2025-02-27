package prototype.ex02;

import java.util.HashMap;

public class Manager {
    private final HashMap<String, Product> showCase = new HashMap<>();

    // register 메서드를 호출하면 HashMap에 담아준다.
    public void register(String name, Product proto) {
        showCase.put(name, proto);
    }
    // key 값을 인자값으로 받아 HashMap에서 꺼내어
    // 해당 인스턴스의 구현 메서드인 createClone()을 호출해 메서드를 복사해 반환합니다.
    // Product라는 인터페이스이름만 가지고 사용하고 있기에 실제 구현클래스와의 관계를 맺지 않습니다.
    public Product create(String protoName) {
        Product p = showCase.get(protoName);
        return p.createClone();
    }
}
