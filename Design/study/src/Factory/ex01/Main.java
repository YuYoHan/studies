package Factory.ex01;

public class Main {
    public static void main(String[] args) {
        Coffee latte = CoffeeFactory.getCoffee("Latte", 4000);
        Coffee ame = CoffeeFactory.getCoffee("Americano", 1500);
        System.out.println("Factory Latte : " + latte);
        System.out.println("Factory Americano : " + ame);
    }
}
