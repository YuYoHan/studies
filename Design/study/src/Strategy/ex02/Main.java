package Strategy.ex02;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Item a = new Item("A", 1000);
        Item b = new Item("B", 2000);

        cart.addItem(a);
        cart.addItem(b);

        cart.pay(new KakaoCard("zxzz", "1234",  "1234", "12/01"));
        cart.pay(new Luna("xzxx", "1234"));
    }
}
