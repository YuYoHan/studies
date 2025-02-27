package Strategy.ex02;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Item> items = new ArrayList<>();

    // 장바구니에 상품 담기
    public void addItem(Item item) {
        this.items.add(item);
    }

    // 장바구니에서 상품 빼기
    public void removeItem(Item item) {
        this.items.remove(item);
    }

    // 장바구니에 담긴 상품들의 전체 금액
    public int payTotal() {
        int sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }
    //  계산
    // 여기서 PaymentStrategy 인터페이스를 상속받은
    // 클래스에서 어떤 카드로 계산할지 나온다.
    public void pay(PaymentStrategy pay) {
        int amount = payTotal();
        pay.pay(amount);
    }
}
